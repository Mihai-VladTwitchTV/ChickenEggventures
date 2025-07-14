package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    public GamePanel gamePanel;

    public ChunkLoader loader;
    List<Tile> tiles = new ArrayList<>();
    int tileCount = 24;

    int mapSize = 16; ///5x5 map



    public TileManager(GamePanel gamePanel) throws IOException {

        this.gamePanel = gamePanel;
        tileCount=10;
        populate();
        getTileSprite();

        this.loader = new ChunkLoader();
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

    public void requestNewChunk(String direction){
        loader.loadNewChunk(direction);
    }


    public void draw(Graphics2D g2){

        int[][] map = loader.getCurrentChunk().getMapMatrix();

        for(int i=0;i<mapSize;i++)
            for(int j=0;j<mapSize;j++){
                g2.drawImage(tiles.get(map[i][j]).sprite,j*gamePanel.TILESIZE,i*gamePanel.TILESIZE,gamePanel.TILESIZE,gamePanel.TILESIZE,null);
            }

    }

    public void populate(){
        for(int i=0;i<tileCount;i++) {
            this.tiles.add(new Tile());
        }
    }
}
