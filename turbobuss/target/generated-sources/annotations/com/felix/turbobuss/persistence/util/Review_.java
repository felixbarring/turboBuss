package com.felix.turbobuss.persistence.util;

import com.felix.turbobuss.persistence.util.Book;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-18T20:33:37")
@StaticMetamodel(Review.class)
public class Review_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Review, String> text;
    public static volatile SingularAttribute<Review, Book> book;
    public static volatile SingularAttribute<Review, Date> reviewDate;

}