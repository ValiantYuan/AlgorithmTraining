import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * @author Valiant
 *
 */
public class ConsistentHashingWithoutVirtualNode
{
    /**
     * �������Hash���ķ������б�
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};
    
    /**
     * key��ʾ��������hashֵ��value��ʾ������������
     */
    private static SortedMap<Integer, String> sortedMap = 
            new TreeMap<Integer, String>();
    
    /**
     * �����ʼ���������еķ���������sortedMap��
     */
    static
    {
        for (int i = 0; i < servers.length; i++)
        {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]���뼯����, ��HashֵΪ" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }
    
    /**
     * ʹ��FNV1_32_HASH�㷨�����������Hashֵ,���ﲻʹ����дhashCode�ķ���������Ч��û���� 
     */
    private static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        
        // ����������ֵΪ������ȡ�����ֵ
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
    
    /**
     * �õ�Ӧ��·�ɵ��Ľ��
     */
    private static String getServer(String node)
    {
        // �õ���·�ɵĽ���Hashֵ
        int hash = getHash(node);
        // �õ����ڸ�Hashֵ������Map
        SortedMap<Integer, String> subMap = 
                sortedMap.tailMap(hash);
        // ��һ��Key����˳ʱ���ȥ��node������Ǹ����
        Integer i = subMap.firstKey();
        // ���ض�Ӧ�ķ���������
        return subMap.get(i);
    }
    
    public static void main(String[] args)
    {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i = 0; i < nodes.length; i++)
            System.out.println("[" + nodes[i] + "]��hashֵΪ" + 
                    getHash(nodes[i]) + ", ��·�ɵ����[" + getServer(nodes[i]) + "]");
    }
}