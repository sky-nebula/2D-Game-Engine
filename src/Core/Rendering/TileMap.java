package Core.Rendering;
import Core.Math.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileMap {
    Sprite IMAGE;
    Sprite TILESHEET;
    Vector2D TILESIZE;
    int[][] MAP;
    Vector2D MAPSIZE;
    //Constructors
    public TileMap(){
        TILESHEET = new Sprite();
        TILESIZE = Vector2D.X16();
        MAP = new int[1][1];
        MAPSIZE = Vector2D.ONE();
        GenerateMap();
    }
    public TileMap(String path, Vector2D tilesize, int[][] map){
        TILESHEET = new Sprite(path);
        TILESIZE = tilesize;
        MAP = map;
        MAPSIZE = new Vector2D(MAP[0].length, MAP.length);
        GenerateMap();
    }
    //Setters
    public void SetTILESHEET(Sprite tilesheet){
        TILESHEET = tilesheet;
    }
    public void SetTILESIZE(Vector2D tilesize){
        TILESIZE = tilesize;
    }
    public void SetMAP(int[][] map){
        MAP = map;
        MAPSIZE = new Vector2D(MAP[0].length, MAP.length);
    }
    //Getters
    BufferedImage GetTile(int Index){
        Vector2D OFFSET = new Vector2D(
                Index%(TILESHEET.SIZE.X/TILESIZE.X)* TILESIZE.X,
                Index/(TILESHEET.SIZE.X/TILESIZE.X)* TILESIZE.Y);
        return TILESHEET.GetSubIMAGE(TILESIZE, OFFSET);
    }
    //Mutators
    void GenerateMap(){
        BufferedImage RenderedImage = new BufferedImage(
                MAPSIZE.X*TILESIZE.X,
                MAPSIZE.Y*TILESIZE.Y,
                BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = RenderedImage.createGraphics();
        for(int y = 0; y < MAPSIZE.Y; y++)
            for (int x = 0; x < MAPSIZE.X; x++){
                BufferedImage Tile = GetTile(MAP[y][x]);
                g2.drawImage(Tile,TILESIZE.X*x, TILESIZE.Y*y, null);
            }
        g2.dispose();
        IMAGE = new Sprite(RenderedImage);
    }
}