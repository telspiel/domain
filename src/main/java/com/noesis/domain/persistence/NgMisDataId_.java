package com.noesis.domain.persistence;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-10T01:18:42.285+0530")
@StaticMetamodel(NgMisDataId.class)
public class NgMisDataId_ {
	public static volatile SingularAttribute<NgMisDataId, String> userName;
	public static volatile SingularAttribute<NgMisDataId, BigDecimal> totalSubmitted;
	public static volatile SingularAttribute<NgMisDataId, BigDecimal> totalRejected;
	public static volatile SingularAttribute<NgMisDataId, BigDecimal> totalDelivered;
	public static volatile SingularAttribute<NgMisDataId, BigDecimal> totalFalied;
}
