package Core.Rendering;
import Core.Engine.GameObject;
import Core.Math.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileMap extends GameObject {
    Sprite SPRITE;
    Sprite TILESHEET;
    Vector2D MAPSIZE;
    Vector2D TILESIZE;
    int[][] MAP;
    public TileMap(){}
    public TileMap(String path, Vector2D TILESIZE, int[][]MAP){

        TILESHEET = new Sprite(path);
        this.TILESIZE = TILESIZE;
        this.MAP = MAP;
        MAPSIZE = new Vector2D(MAP[0].length, MAP.length);
        GenerateMap();

    }
    BufferedImage GetTile(int Index, Sprite TILESHEET){
        Vector2D OFFSET = new Vector2D(
                Index%(TILESHEET.SIZE.X/TILESIZE.X)* TILESIZE.X,
                Index/(TILESHEET.SIZE.X/TILESIZE.X)* TILESIZE.Y);
        return TILESHEET.GetSubSprite(TILESIZE, OFFSET);
    }
    void GenerateMap(){
        BufferedImage RenderedMap = new BufferedImage(
                MAPSIZE.X*TILESIZE.X,
                MAPSIZE.Y*TILESIZE.Y,
                BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = RenderedMap.createGraphics();
        for(int y = 0; y < MAPSIZE.Y; y++)
            for (int x = 0; x < MAPSIZE.X; x++){
                BufferedImage Tile = GetTile(MAP[y][x], TILESHEET);
                g2.drawImage(Tile,TILESIZE.X*x, TILESIZE.Y*y, null);
            }
        g2.dispose();
        SPRITE = new Sprite(RenderedMap);
    }
    public void Render(){
        GamePanel.TileMapLayer.add(SPRITE);
    }
}