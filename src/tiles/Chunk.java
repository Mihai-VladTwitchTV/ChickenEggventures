package tiles;

public class Chunk {

    public Chunk(){};

    private int[][] mapMatrix;


    public Chunk(int[][] mapMatrix){
        this.mapMatrix=mapMatrix;
    }



    public int[][] getMapMatrix() {
        return mapMatrix;
    }


    public void setMapMatrix(int[][] mapMatrix) {
        this.mapMatrix = mapMatrix;
    }
}
