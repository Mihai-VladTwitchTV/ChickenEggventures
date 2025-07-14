package tiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import tiles.Chunk;

import java.io.File;
import java.io.IOException;
import java.rmi.server.RemoteRef;


public class ChunkLoader {

    private static final int  CHUNK_AMOUNT = 25;
    private final int STARTUP_X = 2;
    private final int STARTUP_Y = 2;

    private static final int REGION_HEIGHT = 5;
    private static final int REGION_WIDTH = 5;


    private Chunk currentChunk;

    private Region currentRegion;

    private int[] chunkMap;

    public ChunkLoader() throws IOException {
        loadStartupRegion();
        loadStartupChunk();
    }

    public static Chunk generateChunk (int[] map){

            return null;
    }

    public static int[] getIndices(Chunk chunk,Region region){//could break if tileMaps of chunks are identical between 2 diff chunks
        for(int i=0;i<REGION_WIDTH;i++){
            for(int j=0;j<REGION_HEIGHT;j++){
                if(region.getChunkMap()[i][j]==chunk)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public boolean checkExistsNextChunk(String direction){
        int[] indeces = getIndices(currentChunk,currentRegion);
        switch(direction) {
            case "up":
                if(indeces[0] > 0)
                    return true;
                return false;
            case "down":
                if(indeces[0]<REGION_HEIGHT-1)
                    return true;
                return false;
            case "left":
                if(indeces[1]>0)
                    return true;
                return false;
            case "right":
                if(indeces[1]<REGION_WIDTH-1)
                    return true;
                return false;
            default:return false;
        }
    }

    public Chunk getCurrentChunk() {
        return currentChunk;
    }

    //loads starting region in memory
    public void loadStartupRegion() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String filename = "res/regions/0_0.json";
        Region reg = mapper.readValue(new File(filename), Region.class);
        this.currentRegion=reg;
    }
    //loads central chunk of the startup region
    public void loadStartupChunk(){
        this.currentChunk = this.currentRegion.getChunkMap()[STARTUP_X][STARTUP_Y];
    }

    public void loadNewChunk(String direction){
        if(!checkExistsNextChunk(direction))
            throw new RuntimeException("No chunk there");

        int[] indeces = getIndices(currentChunk,currentRegion);
        Chunk newChunk;

        switch(direction){
            case "up":
                newChunk = currentRegion.getChunkMap()[indeces[0]-1][indeces[1]];
                currentChunk = newChunk;
                return;
            case "down":
                newChunk = currentRegion.getChunkMap()[indeces[0]+1][indeces[1]];
                currentChunk = newChunk;
                return;
            case "left":
                newChunk = currentRegion.getChunkMap()[indeces[0]][indeces[1]-1];
                currentChunk = newChunk;
                return;
            case "right":
                newChunk = currentRegion.getChunkMap()[indeces[0]][indeces[1]+1];
                currentChunk = newChunk;
                return;
            default:
                return;
        }
    }



}
