package redis;

import java.util.List;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.geo.GeoRadiusParam;

/*
 * 
 * redis geo µÿ¿ÌŒª÷√
 * 
 */
public class RedisTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jedis jedis = new Jedis("127.0.0.1", 6379);

//		 jedis.set("a", "123");
//		 System.out.println(jedis.get("a"));
		

//		 jedis.lpush("lists", "aaa");
//		 jedis.lpush("lists", "bbb");
//		 jedis.lpush("lists", "ccc");

//		jedis.linsert("lists", LIST_POSITION.AFTER, jedis.lindex("lists", 0), "-1-1-1");

//		 jedis.geoadd("list", 118.7959977635, 32.0583078428, "001");
//		 jedis.geoadd("list", 118.8219949131, 32.0320617624, "002");
//		 jedis.geoadd("list", 118.7907330008, 32.0193177738, "003");
//		 jedis.geoadd("list", 118.8028156128, 32.0004621505, "004");

//		List<GeoRadiusResponse> list = jedis.georadius("list", 118.8162792598, 32.0470780513, 10, GeoUnit.KM,
//				GeoRadiusParam.geoRadiusParam().withDist());
		
		/*
		 * æ‡¿Î004  5.3381km
		 * æ‡¿Î003  3.9161km
		 * æ‡¿Î002  1.7551km
		 * æ‡¿Î001  2.2836km
		 * 
		 * */

		// http://redisdoc.com/geo/georadius.html
		List<GeoRadiusResponse> list = jedis.georadius("list", 118.8162792598, 32.0470780513, 10, GeoUnit.KM,
				GeoRadiusParam.geoRadiusParam().withDist().sortAscending().count(1));
		
		// System.out.println(list.size());

		for (GeoRadiusResponse geo : list) {
			System.out.println("æ‡¿Î" + geo.getMemberByString() + "  " + geo.getDistance() + "km");
		}

	}

}
