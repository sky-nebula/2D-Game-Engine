package Core.Engine;

import Core.Math.Vector2D;

public class MapGen {
    public static int[][] NineSlicedMap(Vector2D mapsize){
        int[][] tilemapdata = new int[mapsize.Y][mapsize.X];
        for(int i = 0; i < mapsize.X; i++){
            for(int j = 0; j < mapsize.Y; j++){
                tilemapdata[j][i] =4;
            }
        }
        for(int i = 0; i < mapsize.X; i++){
            tilemapdata[0][i] = 1;
            tilemapdata[mapsize.Y-1][i] = 7;
        }
        for(int i = 0; i < mapsize.Y; i++){
            tilemapdata[i][0] = 3;
            tilemapdata[i][mapsize.X-1] = 5;
        }
        tilemapdata[0][0]=0;
        tilemapdata[0][mapsize.X-1]=2;
        tilemapdata[mapsize.Y-1][0]=6;
        tilemapdata[mapsize.Y-1][mapsize.X-1]=8;
        return tilemapdata;
    }
}
