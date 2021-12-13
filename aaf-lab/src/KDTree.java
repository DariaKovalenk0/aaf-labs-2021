import java.math.BigInteger;

public class KDTree {
    KDTree left=null;
    KDTree right=null;
    KDNode node;
    public void KDTree(String bounds){
        KDNode x = new KDNode();
        x.bRight = new BigInteger(bounds.split(",")[1]);
        x.bLeft = new BigInteger(bounds.split(",")[0]);
        this.node=x;
    }

}
