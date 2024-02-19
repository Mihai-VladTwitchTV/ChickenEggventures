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
    int tileCount;

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
        g2.drawImage(tiles.get(1).sprite,0,0,gamePanel.TILESIZE,gamePanel.TILESIZE,null);
    }

    public void populate(){
        for(int i=0;i<tileCount;i++) {
            this.tiles.add(new Tile());
        }
    }
}
