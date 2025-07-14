package tiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import tiles.Chunk;

import java.io.File;
import java.io.IOException;

public class ChunkLoader {

    private static final int  CHUNK_AMOUNT = 9;
    private final int STARTUP_X = 2;
    private final int STARTUP_Y = 2;


    private Chunk currentChunk;

    private Region currentRegion;

    private int[] chunkMap;

    public ChunkLoader() throws IOException {
        loadStartupRegion();
        loadStartupChunk();
    }

    public static Chunk generateChunk (int[] map){


        int mapp[][] = {{2,2,2,2,2,2,2,2,0,0,0,0,0,0,1,0},
                        {2,0,0,0,0,0,0,2,0,0,0,0,0,1,1,0},
                        {2,0,0,0,0,0,0,2,0,0,0,0,0,1,0,0},
                        {2,0,0,0,0,0,0,2,0,0,0,0,0,1,0,0},
                        {2,0,0,0,0,0,0,2,0,0,0,0,1,1,0,0},
                        {2,2,2,0,0,2,2,2,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
                        {0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}


        };



        return new Chunk(mapp);
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



}
