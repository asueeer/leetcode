package dfs;

import java.util.*;

/**
 * @author wangyisu
 */
public class Solution1036 {
    int threshold = 10000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String> blockedSet = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            blockedSet.add(Arrays.toString(blocked[i]));
        }
        HashSet<String> visited = new HashSet<>();
        bfs(blockedSet, source, target, visited);
        boolean fromSrc = false;
        if(visited.contains(Arrays.toString(target)) || visited.size()>=threshold){
            fromSrc = true;
        }
        visited.clear();
        bfs(blockedSet, target, source, visited);
        boolean formDst = false;
        if(visited.contains(Arrays.toString(source)) || visited.size()>=threshold){
            formDst = true;
        }
        return fromSrc&&formDst;
    }

    private void bfs(HashSet<String> blockedSet, int[] source, int[] target, HashSet<String> visited) {
        if(visited.contains(Arrays.toString(source)) || visited.contains(Arrays.toString(target)) || visited.size()>=threshold){
            return;
        }
        if(blockedSet.contains(Arrays.toString(source))){
            return;
        }
        visited.add(Arrays.toString(source));
        int[][] nexts = new int[][]{{source[0]+1,source[1]},{source[0]-1,source[1]},{source[0],source[1]+1},{source[0],source[1]-1}};
        for (int i = 0; i < nexts.length; i++) {
            int[] next = nexts[i];
            if(next[0]<0 || next[1]<0 || next[0]>=1000000 || next[1]>=1000000){
                continue;
            }
            bfs(blockedSet, next, target, visited);
        }
    }

    public static void main(String[] args) {
        Solution1036 solu = new Solution1036();
//        System.out.println(solu.isEscapePossible(new int[][]{{0,1},{1,0}}, new int[]{0,0}, new int[]{0,2}));
//        System.out.println(10000000);
//        System.out.println(solu.isEscapePossible(new int[][]{{100025,100025},{100026,100026},{100027,100027},{100028,100028},{100029,100029},{100030,100030},{100031,100031},{100032,100032},{100033,100033},{100034,100034},{100035,100035},{100036,100036},{100037,100037},{100038,100038},{100039,100039},{100040,100040},{100041,100041},{100042,100042},{100043,100043},{100044,100044},{100045,100045},{100046,100046},{100047,100047},{100048,100048},{100049,100049},{100050,100050},{100051,100051},{100052,100052},{100053,100053},{100054,100054},{100055,100055},{100056,100056},{100057,100057},{100058,100058},{100059,100059},{100060,100060},{100061,100061},{100062,100062},{100063,100063},{100064,100064},{100065,100065},{100066,100064},{100067,100063},{100068,100062},{100069,100061},{100070,100060},{100071,100059},{100072,100058},{100073,100057},{100074,100056},{100075,100055},{100076,100054},{100077,100053},{100078,100052},{100079,100051},{100080,100050},{100081,100049},{100082,100048},{100083,100047},{100084,100046},{100085,100045},{100086,100044},{100087,100043},{100088,100042},{100089,100041},{100090,100040},{100091,100039},{100092,100038},{100093,100037},{100094,100036},{100095,100035},{100096,100034},{100097,100033},{100098,100032},{100099,100031},{100100,100030},{100101,100029},{100102,100028},{100103,100027},{100104,100026},{100105,100025},{100104,100024},{100103,100023},{100102,100022},{100101,100021},{100100,100020},{100099,100019},{100098,100018},{100097,100017},{100096,100016},{100095,100015},{100094,100014},{100093,100013},{100092,100012},{100091,100011},{100090,100010},{100089,100009},{100088,100008},{100087,100007},{100086,100006},{100085,100005},{100084,100004},{100083,100003},{100082,100002},{100081,100001},{100080,100000},{100079,99999},{100078,99998},{100077,99997},{100076,99996},{100075,99995},{100074,99994},{100073,99993},{100072,99992},{100071,99991},{100070,99990},{100069,99989},{100068,99988},{100067,99987},{100066,99986},{100065,99985},{100064,99986},{100063,99987},{100062,99988},{100061,99989},{100060,99990},{100059,99991},{100058,99992},{100057,99993},{100056,99994},{100055,99995},{100054,99996},{100053,99997},{100052,99998},{100051,99999},{100050,100000},{100049,100001},{100048,100002},{100047,100003},{100046,100004},{100045,100005},{100044,100006},{100043,100007},{100042,100008},{100041,100009},{100040,100010},{100039,100011},{100038,100012},{100037,100013},{100036,100014},{100035,100015},{100034,100016},{100033,100017},{100032,100018},{100031,100019},{100030,100020},{100029,100021},{100028,100022},{100027,100023},{100026,100024}}, new int[]{100065,100025}, new int[] {999993,999952}));
        System.out.println(solu.isEscapePossible(new int[][]{{0,199},{1,198},{2,197},{3,196},{4,195},{5,194},{6,193},{7,192},{8,191},{9,190},{10,189},{11,188},{12,187},{13,186},{14,185},{15,184},{16,183},{17,182},{18,181},{19,180},{20,179},{21,178},{22,177},{23,176},{24,175},{25,174},{26,173},{27,172},{28,171},{29,170},{30,169},{31,168},{32,167},{33,166},{34,165},{35,164},{36,163},{37,162},{38,161},{39,160},{40,159},{41,158},{42,157},{43,156},{44,155},{45,154},{46,153},{47,152},{48,151},{49,150},{50,149},{51,148},{52,147},{53,146},{54,145},{55,144},{56,143},{57,142},{58,141},{59,140},{60,139},{61,138},{62,137},{63,136},{64,135},{65,134},{66,133},{67,132},{68,131},{69,130},{70,129},{71,128},{72,127},{73,126},{74,125},{75,124},{76,123},{77,122},{78,121},{79,120},{80,119},{81,118},{82,117},{83,116},{84,115},{85,114},{86,113},{87,112},{88,111},{89,110},{90,109},{91,108},{92,107},{93,106},{94,105},{95,104},{96,103},{97,102},{98,101},{99,100},{100,99},{101,98},{102,97},{103,96},{104,95},{105,94},{106,93},{107,92},{108,91},{109,90},{110,89},{111,88},{112,87},{113,86},{114,85},{115,84},{116,83},{117,82},{118,81},{119,80},{120,79},{121,78},{122,77},{123,76},{124,75},{125,74},{126,73},{127,72},{128,71},{129,70},{130,69},{131,68},{132,67},{133,66},{134,65},{135,64},{136,63},{137,62},{138,61},{139,60},{140,59},{141,58},{142,57},{143,56},{144,55},{145,54},{146,53},{147,52},{148,51},{149,50},{150,49},{151,48},{152,47},{153,46},{154,45},{155,44},{156,43},{157,42},{158,41},{159,40},{160,39},{161,38},{162,37},{163,36},{164,35},{165,34},{166,33},{167,32},{168,31},{169,30},{170,29},{171,28},{172,27},{173,26},{174,25},{175,24},{176,23},{177,22},{178,21},{179,20},{180,19},{181,18},{182,17},{183,16},{184,15},{185,14},{186,13},{187,12},{188,11},{189,10},{190,9},{191,8},{192,7},{193,6},{194,5},{195,4},{196,3},{197,2},{198,1},{199,0}} ,new int[]{0,0}, new int[]{200,200}));
    }
}
