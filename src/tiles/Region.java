package tiles;

public class Region {
    private Integer coordX;
    private Integer coordY;

    private Chunk[][] chunkMap;

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public Chunk[][] getChunkMap() {
        return chunkMap;
    }

    public void setChunkMap(Chunk[][] chunkMap) {
        this.chunkMap = chunkMap;
    }
}
