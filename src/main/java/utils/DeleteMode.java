package utils;

/**
 * Created by burning on 2016/3/20.
 */
public class DeleteMode {
    /*如果是单表，直接删除*/
    public static final String DEL="del";
    /*一对多的表，在删除之前先解除关系*/
    public static final String DEL_PRE_RELEASE="del_pre_release";
    /*多个表之间有关系，进行级联删除*/
    public static final String DEL_CASCADE="del_cascade";
}
