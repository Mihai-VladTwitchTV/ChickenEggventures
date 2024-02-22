package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    public GamePanel gamePanel;
    List<Tile> tiles = new ArrayList<>();
    int tileCount = 24;

    int mapSize = 16; ///5x5 map

    int map[] = {2,2,2,2,2,2,2,2,0,0,0,0,0,0,1,0,
                 2,0,0,0,0,0,0,2,0,0,0,0,0,1,1,0,
                 2,0,0,0,0,0,0,2,0,0,0,0,0,1,0,0,
                 2,0,0,0,0,0,0,2,0,0,0,0,0,1,0,0,
                 2,0,0,0,0,0,0,2,0,0,0,0,1,1,0,0,
                 2,2,2,0,0,2,2,2,0,0,0,0,1,0,0,0,
                 0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,
                 0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,
                 0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,
                 0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,
                 0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,
                 0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1


    };

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileCount=10;
        populate();
        getTileSprite();
    }

    public void getTileSprite(){
        try{
            tiles.getFirst().sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tiles.get(1).sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tiles.get(2).sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){
        for(int i=0;i<map.length;i++)
            g2.drawImage(tiles.get(map[i]).sprite,(i%mapSize)*gamePanel.TILESIZE,(int)(i/mapSize)*gamePanel.TILESIZE,gamePanel.TILESIZE,gamePanel.TILESIZE,null);

            ///g2.drawImage(tiles.get(i).sprite,i*gamePanel.TILESIZE,i*gamePanel.TILESIZE,gamePanel.TILESIZE,gamePanel.TILESIZE,null);
    }

    public void populate(){
        for(int i=0;i<tileCount;i++) {
            this.tiles.add(new Tile());
        }
    }
}
