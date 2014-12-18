package com.felix.turbobuss.persistence.util;

import com.felix.turbobuss.persistence.util.Review;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-18T20:33:37")
@StaticMetamodel(Book.class)
public class Book_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Book, String> title;
    public static volatile ListAttribute<Book, Review> reviews;
    public static volatile SingularAttribute<Book, Float> price;
    public static volatile SingularAttribute<Book, String> description;

}