package tiles;

public class Chunk {
    private Integer coordX;
    private Integer coordY;

    private int[][] mapMatrix;

    public Chunk(int coordX, int coordY, int[][] mapMatrix) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.mapMatrix = mapMatrix;
    }

    public Chunk(int[][] mapMatrix){
        this.coordX = null;
        this.coordY = null;
        this.mapMatrix=mapMatrix;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public int[][] getMapMatrix() {
        return mapMatrix;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setMapMatrix(int[][] mapMatrix) {
        this.mapMatrix = mapMatrix;
    }
}
