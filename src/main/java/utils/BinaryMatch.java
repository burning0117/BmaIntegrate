package utils;

import domain.Order;
import domain.Production;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lily on 2016/4/27.
 */
public class BinaryMatch {
    private static SessionFactory sessionFactory;
    private int[][] loveA;
    private int[][] loveB;

    static {
        Configuration configuration = new Configuration();
        //加载配置文件
        configuration.configure();
        //采用了工厂模式创建sessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    @Test
    public void tesBinaryMatch() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = new Order();
        order.setName("test");
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Test
    public void tesBinaryMatch2() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String orderHql = "from Order";
        String productionHql = "from Production";
        Query query = session.createQuery(orderHql);
        List<Order> buyer = query.list();
        Query query1 = session.createQuery(productionHql);
        List<Production> seller = query1.list();
        float[][] BM = new float[buyer.size()][seller.size()];
        float[][] SM = new float[seller.size()][buyer.size()];
        int[][] BS = new int[buyer.size()][seller.size()];
        int[][] SS = new int[seller.size()][buyer.size()];
        for (int i = 0; i < buyer.size(); i++) {
            for (int j = 0; j < seller.size(); j++) {
                float b1 = Float.parseFloat(buyer.get(i).getPricerate().toString());
                float b2 = Float.parseFloat(buyer.get(i).getGqosrate().toString());
                float b3 = Float.parseFloat(buyer.get(i).getGreputationrate().toString());
                float s1 = Float.parseFloat(seller.get(j).getPrice().toString());
                float s2 = Float.parseFloat(seller.get(j).getPqos().toString());
                float s3 = Float.parseFloat(seller.get(j).getPreputation().toString());
                BM[i][j] = b1 * s1 + b2 * s2 + b3 * s3;
            }
        }

        for (int i = 0; i < seller.size(); i++) {
            for (int j = 0; j < buyer.size(); j++) {
                float s1 = Float.parseFloat(seller.get(i).getPricerate().toString());
                float s2 = Float.parseFloat(seller.get(i).getPreputationrate().toString());
                float b1 = Float.parseFloat(buyer.get(j).getPrice().toString());
                float b2 = Float.parseFloat(buyer.get(j).getGreputation().toString());
                SM[i][j] = s1 * b1 + s2 * b2;
            }
        }
        float[][] tmpBM = new float[buyer.size()][seller.size()];
        float[][] tmpSM = new float[seller.size()][buyer.size()];
        for (int i = 0; i < buyer.size(); i++) {
            for (int j = 0; j < seller.size(); j++) {
                tmpBM[i][j] = BM[i][j];
            }
        }
        for (int i = 0; i < seller.size(); i++) {
            for (int j = 0; j < buyer.size(); j++) {
                tmpSM[i][j] = SM[i][j];
            }
        }
        for (int i = 0; i < buyer.size(); i++) {
            Arrays.sort(tmpBM[i]);
        }
        for (int i = 0; i < buyer.size(); i++) {
            for (int j = 0; j < seller.size(); j++) {
                for (int k = 0; k < seller.size(); k++) {
                    if (BM[i][j] == tmpBM[i][k]) {
                        BS[i][k] = j;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < seller.size(); i++) {
            Arrays.sort(tmpSM[i]);
        }
        for (int i = 0; i < seller.size(); i++) {
            for (int s = 0; s < buyer.size(); s++) {
                for (int j = 0; j < buyer.size(); j++) {
                    if (SM[i][s] == tmpSM[i][j]) {
                        SS[i][j] = s;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < seller.size(); i++) {
            org.apache.commons.lang.ArrayUtils.reverse(SS[i]);
        }
        for (int i = 0; i < buyer.size(); i++) {
            org.apache.commons.lang.ArrayUtils.reverse(BS[i]);
        }
        if (buyer.size() > seller.size()) {
            System.out.println("处于卖方市场,卖方随便挑买方");
            int[][] loveBuyer = new int[buyer.size()][seller.size() + 1];
            int[][] loveSeller = new int[seller.size()][buyer.size()];
            /*买方购买次数*/
            int[] Buyer = new int[seller.size()];
            /*卖方选择状态*/
            int[] Seller = new int[buyer.size() + 1];

            /*卖方有个买的了*/
            for (int i = 0; i < buyer.size() + 1; i++) {
                Seller[i] = 0;
            }

            /*买方交易过的次数*/
            for (int i = 0; i < seller.size(); i++) {
                Buyer[i] = seller.size();
            }
            /*[max][max+1]数组*/
            for (int i = 0; i < buyer.size(); i++) {
                for (int j = 0; j < seller.size() + 1; j++) {
                    if (j == seller.size()) {
                        loveBuyer[i][seller.size()] = seller.size();
                    } else {
                        loveBuyer[i][j] = BS[i][j];
                    }
                }
            }
            /*[max][max]的数组*/
            for (int i = 0; i < seller.size(); i++) {
                for (int j = 0; j < buyer.size(); j++) {
                    loveSeller[i][j] = SS[i][j];
                }
            }
            int i = 0;
            this.loveA = loveBuyer;
            this.loveB = loveSeller;
            while (i < seller.size()) {
                int v = loveSeller[i][Seller[i]];
                if (i == Buyer[v]) {
                    i++;
                } else if (ChangeFriend(buyer.size(), v, Buyer[v], i)) {
                    int t = Buyer[v];
                    Seller[Buyer[v]]++;
                    Buyer[v] = i;
                    if (t > i) {
                        i++;
                    } else {
                        i = t;
                    }
                } else {
                    Seller[i]++;
                }
            }
        } else if (buyer.size() == seller.size()) {


        } else {
            System.out.println("处于买方市场,买方随便挑卖方");
        }
        transaction.commit();
        session.close();
    }

    public Boolean ChangeFriend(int size, int v, int oldF, int newF) {
        for (int i = 0; i < size; i++) {
            if (loveA[v][i] == oldF) {
                oldF = i;
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (loveA[v][i] == newF) {
                newF = i;
                break;
            }
        }
        return (oldF > newF);
    }
}
