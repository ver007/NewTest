import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class JDBCGetData {
	
	private int[] ids = new int[100];
	Random ran = new Random();

	public Map<String, Object> queryDate() {
		Set<Object> nodes = createNodes();
		Set<Object> links = createLinks(ids);
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("links", links);
        map.put("nodes", nodes);
		return map;
	}
	
	
	public Set<Object> createNodes(){
		Set<Object> set = new HashSet<Object>();
		for(int i= 0;i<100;i++){
			Node node = new Node();
			//ids[i] = ran.nextInt(100)+"";
            ids[i] = i;
			node.setId(ids[i]);
			node.setX(ran.nextDouble()*500);
			node.setY(ran.nextDouble()*500);
			set.add(node);
		}
		return set;
	}
	
	public Set<Object> createLinks(int[] ids){
		Set<Object> Set = new HashSet<Object>();
		for(int i =0;i<100;i++){
            Link e = new Link();
            int s= ran.nextInt(ids.length);
            int t= ran.nextInt(ids.length);
            if(s!=t) {
                e.setSource(ids[s]);
                e.setTarget(ids[t]);
                Set.add(e);
            }
		}
		return Set;
	}
	

}
