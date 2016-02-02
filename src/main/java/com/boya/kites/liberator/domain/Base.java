package com.boya.kites.liberator.domain;

import org.canedata.field.Fields;
/**
 * Created  IN BOYA by BaiLiJun on 14-10-11.
 */
public interface Base<T> {

    T   fill(Fields field);

}
