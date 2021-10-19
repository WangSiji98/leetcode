package com.oasis.problems.amazon.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import sun.dc.pr.PRError;

enum Rank {
    // 头等舱
    FIRST(0),
    // 商务舱
    BUSSINESS(1),
    // 经济舱
    ECONOMY(2);
    private int type;
    private Rank(int _type) {
        type = _type;
    }

    public int getType() {
        return type;
    }
}


interface Plane {

    void booking(String name, Rank rank);

    List<String> boarding();

}

public class PlaneImpl implements Plane{

    class Passenger {
        String name;
        Rank rank;
        int index;
        public Passenger(){}
        public Passenger(String _name, Rank _rank, int _index) {
            name = _name;
            rank = _rank;
            index = _index;
        }
    }

    private PriorityQueue<Passenger> pq;
    private Map<Rank, Integer> map;


    public PlaneImpl() {
        pq = new PriorityQueue<Passenger>(
            new Comparator<Passenger>() {
                @Override
                public int compare(Passenger p1, Passenger p2) {
                    return p1.rank == p2.rank ? p1.index - p2.index : p1.rank.getType() - p2.rank.getType();
                }
            }
        );
        map = new HashMap<Rank, Integer>();
    }

    @Override
    public void booking(String name, Rank rank) {
        map.put(rank, map.getOrDefault(rank, -1) + 1);
        pq.offer(new Passenger(name, rank, map.get(rank)));
    }

    @Override
    public List<String> boarding() {
        List<String> orderList = new ArrayList<>();
        while (!pq.isEmpty()) {
            orderList.add(pq.poll().name);
        }
        return orderList;
    }
}
