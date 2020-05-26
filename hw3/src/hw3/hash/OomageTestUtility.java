package hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int[] buckets = new int[M+1];
        for(int i=0; i< M+1; i++) buckets[i] = 0;
        int bucketNum;
        List<Oomage> o = oomages;
        for(int i=0; i < o.size(); i++){
            bucketNum = (o.get(i).hashCode() & 0x7FFFFFFF) % M; // & （求and，都为1得1）
            buckets[bucketNum] += 1;
        }

        for(int i=0; i <M+1;i++){
            if(buckets[i] == 0) continue;
            if(buckets[i] < o.size()/50) return false;
            if(buckets[i] > (float)o.size()/2.5) return false;
        }
        return true;

    }
}
