package Core.Rendering;

import Core.Engine.Game;
import Core.Engine.GameObject;
import Core.Math.Vector2D;

public class UIPanel extends TileMap {
    TileMap Panel;

    public UIPanel(String Path, Vector2D TileSize, Vector2D PanelSize){
        int horizontalSize = PanelSize.X/TileSize.X;
        int verticalSize = PanelSize.Y/TileSize.Y;
        int[][] PanelMap = new int[horizontalSize][verticalSize];
        //012
        //345
        //678
        for(int i = 0; i < horizontalSize; i++){
            for(int j = 0; j < verticalSize; j++){
                PanelMap[j][i] =4;
            }
        }
        for(int i = 0; i < horizontalSize; i++){
            PanelMap[0][i] = 1;
            PanelMap[verticalSize-1][i] = 7;
        }
        for(int i = 0; i < verticalSize; i++){
            PanelMap[i][0] = 3;
            PanelMap[i][horizontalSize-1] = 5;
        }
        PanelMap[0][0]=0;
        PanelMap[0][horizontalSize-1]=2;
        PanelMap[verticalSize-1][0]=6;
        PanelMap[verticalSize-1][horizontalSize-1]=8;
        super(Path, TileSize, PanelMap);
    }
    public void Render(){
        GamePanel.UILayer.add(SPRITE);
    }

}
