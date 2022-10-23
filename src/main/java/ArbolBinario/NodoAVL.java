package ArbolBinario;

public class NodoAVL {
    private Integer dataAVL;
    private Integer concurrenciasAVL;
    private Integer factorEquilibrio;
    private NodoAVL leftchild;
    private NodoAVL rightchild;

    public NodoAVL(Integer dataAVL, Integer concurrenciasAVL){
        this.dataAVL = dataAVL;
        this.concurrenciasAVL = concurrenciasAVL;
        this.factorEquilibrio = 0;
        this.leftchild = null;
        this.rightchild = null;
    }

    public Integer getDataAVL() {
        return this.dataAVL;
    }

    public Integer getfactorEquilibrio() {
        return this.factorEquilibrio;
    }

    public void setFactorEquilibrio(Integer factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    public NodoAVL getAVLLeftchild() {
        return this.leftchild;
    }

    public void setAVLLeftchild(NodoAVL leftchild) {
        this.leftchild = leftchild;
    }

    public NodoAVL getAVLRightchild() {
        return this.rightchild;
    }

    public void setAVLRightchild(NodoAVL rightchild) {
        this.rightchild = rightchild;
    }

    public Integer getConcurrenciasAVL() {
        return concurrenciasAVL;
    }
}
