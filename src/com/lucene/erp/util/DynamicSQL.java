package com.lucene.erp.util ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 动态SQL处理，参数部分使用?、#代替。 $代表常量 #代表对象
 * demo:
 * <pre>
 * DynamicSQL dsql = new DynamicSQL() ;
 * 
 * dsql.append("             SELECT s.dept_name, s.id, s.name, t.year, t.semester, t.course_id, t.grade  ") ;
 * dsql.append("               FROM student s                                                            ") ;
 * dsql.append("               LEFT JOIN takes t ON s.id = t.id                                          ") ;
 * dsql.append("              where s.id = '1'                                                           ") ;
 * dsql.isNotEmpty("2009",
 *             "                and t.year = #                                                           ") ;
 * dsql.isEqual(1,1,
 *             "                and t.semester = $                                                       ") ;
 * </pre>
 * @author Lyn_Chen 2012-3-30 下午02:40:01
 */
public class DynamicSQL {

	private StringBuffer str = new StringBuffer();

	private ArrayList<Object> params = new ArrayList<Object>();

	/**
	 * 参数不为NULL、“”的时候，拼接sqltmp。
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:01:49
	 */
	public <T> DynamicSQL isNotEmpty(T param, String sqltmp) {
		if (param == null || "".equals(param)) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * 参数不为NULL、“”的时候，拼接sqltmp。
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:01:49
	 */
	public <T> DynamicSQL isNotEmptyAll(String sqltmp ,final Object...params) {
		int j = 0;
		for (int i = 0; i < params.length; i++) {
			if (params[i] == null || "".equals(params[i])) {
				j++;
			}
		}
		if(params.length!=j){
			this.str.append(sqltmp);
		}
		System.out.println("j:"+j+"   length:"+params.length);
		return this;
	}
	
	/**
	 * 参数为NULL、“”的时候，拼接sqltmp。
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:02:36
	 */
	public <T> DynamicSQL isEmpty(T param, String sqltmp) {
		if (param != null || !"".equals(param)) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * param==cmpVal || param equals cmpVal 的时候拼接
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @param cmpVal
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:02:53
	 */
	public <T> DynamicSQL isNotEqual(T param, T cmpVal, String sqltmp) {
		if (this.isBaseType(param) && param == cmpVal) {
			return this;
		}
		if (!this.isBaseType(param) && param.equals(cmpVal)) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * param!=cmpVal || param !equals cmpVal 的时候拼接
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @param cmpVal
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:03:55
	 */
	public <T> DynamicSQL isEqual(T param, T cmpVal, String sqltmp) {

		if (this.isBaseType(param) && param != cmpVal) {
			return this;
		}

		if (!this.isBaseType(param) && !param.equals(cmpVal)) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * param!=null 时候拼接
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:04:15
	 */
	public <T> DynamicSQL isNotNull(T param, String sqltmp) {
		if (param == null) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * param==null 时候拼接
	 * 
	 * @param <T>
	 * @param sqltmp
	 * @param param
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:04:33
	 */
	public <T> DynamicSQL isNull(T param, String sqltmp) {
		if (param != null) {
			return this;
		}
		this.str.append(sqltmp);
		this.params.add(param);
		return this;
	}

	/**
	 * 正常拼接
	 * 
	 * @param sqltmp
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:04:44
	 */
	public DynamicSQL append(String sqltmp) {
		this.str.append(sqltmp);
		return this;
	}

	/**
	 * 获取动态拼接后的sql，参数?模式。
	 * 
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:04:55
	 */
	public String getSql() {

		String _sql = trimOf();

		return _sql.replaceAll("$", "?").replaceAll("#", "?");
	}

	/**
	 * 获取参数的集合，有顺序与getSql()获取到的sql中的?参数一一对应。
	 * 
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:05:24
	 */
	public List<Object> getParams() {
		this.params.trimToSize();
		return this.params;
	}

	/**
	 * 获取参数的集合，有顺序与getSql()获取到的sql中的?参数一一对应。
	 * 
	 * @param <T>
	 * @param collection
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:51:40
	 */
	public <T extends Collection<Object>> T getParams(T collection) {
		this.params.trimToSize();
		collection.addAll(this.params);
		return collection;
	}

	/**
	 * 获取参数的集合，有顺序与getSql()获取到的sql中的?参数一一对应。
	 * 
	 * @param <T>
	 * @param parameter
	 * @param t
	 * @return
	 * @author Lyn_Chen 2012-3-30 下午03:51:54
	 */
	public <T> T getParams(DynamicSQL.Parameter<T> parameter, T t) {
		this.params.trimToSize();
		return parameter.addAll(params, t);
	}

	/**
	 * 返回参数赋值之后完整的sql
	 */
	@Override
	public String toString() {
		String[] pas = new String[this.params.size()];
		for (int i = 0; i < pas.length; i++) {
			if (this.params.get(i) == null) {
				pas[i] = null;
			} else {
				pas[i] = String.valueOf(this.params.get(i));
			}
		}
		String _sql = trimOf();
		_sql = _sql.replaceAll("\\$", "%s").replaceAll("#", "'%s'");
		return String.format(_sql, pas);
	}

	private boolean isBaseType(Object param) {
		return param instanceof Byte || param instanceof Short
		|| param instanceof Integer || param instanceof Long
		|| param instanceof Float || param instanceof Double
		|| param instanceof Boolean || param instanceof Character
		|| param == null;
	}

	private String trimOf() {
		String _sql = this.str.toString().replaceAll("\t", " ");

		while (_sql.indexOf("  ") != -1) {
			_sql = _sql.replaceAll("  ", " ");
		}
		return _sql;
	}

	public interface Parameter<T> {
		/**
		 * 参数类型转换，需要具体实现。
		 * @param params 源参数集合
		 * @param t 目标参数集合
		 * @return 目标参数集合
		 * @author Lyn_Chen 2012-3-30 下午04:01:50
		 */
		public T addAll(ArrayList<Object> params, T t);
	}
}
