package com.lucene.erp.controller;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;

import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.dao.impl.SaleDaoImpl;
import com.lucene.erp.domain.ResultVo;
import com.lucene.erp.domain.User;
import com.lucene.erp.util.DateUtil;

/**
 * Servlet implementation class AnalyDaySaleServlet
 */
@WebServlet("/AnalyDaySaleServlet")
public class AnalyDaySaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyDaySaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String time = request.getParameter("message");
		Date date = DateUtil.fomatDate(time);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//User user = (User) session.getAttribute("user"); 
		// 解决中文乱码
		StandardChartTheme theme = new StandardChartTheme("CN");
		theme.setExtraLargeFont(new Font("黑体", Font.PLAIN, 16));
		theme.setRegularFont(new Font("黑体", Font.PLAIN, 16));
		theme.setLargeFont(new Font("黑体", Font.PLAIN, 16));
		ChartFactory.setChartTheme(theme);
		// 步骤1：创建初始数据集DefaultPieDataset
		DefaultPieDataset dataset = new DefaultPieDataset();

		// 步骤2：设置数据集数据
		SaleDao saleDao = new SaleDaoImpl();
		List<User> userList = saleDao.queryAllDIANPU();
			if(!userList.isEmpty()){
				for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
					User user = (User) iterator.next();
					ResultVo resultVo = new ResultVo();
					resultVo.setUserId(user.getId());
					resultVo.setName(user.getName());
					resultVo.setDiyDate(date);
					resultVo = saleDao.queryAnalyDay(resultVo);
					dataset.setValue(resultVo.getName(), resultVo.getMoney());
				}
			}
		//dataset.setValue("优秀", 300);
		//dataset.setValue("良好", 400);
		//dataset.setValue("中等", 300);
		//dataset.setValue("合格", 100);
		//dataset.setValue("不及格", 50);
		// 步骤3：创建饼状报表
		JFreeChart chart = ChartFactory.createPieChart3D(request.getParameter("message")+"日报表", dataset, true, true, true);
		// JFreeChart chart = ChartFactory.createPieChart("考试成绩统计图",
		// dataset,true,true,true);

		// 步骤4：利用org.jfree.chart.servlet.ServletUtilities将chart保存为图片，确定宽度与高度，并确定其保存的范围（一般可以用session）
		String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, session);

		// 步骤5：组织图片路径
		String graphURL = "DisplayChart?filename=" + filename;
		out.print(graphURL);
	}

}
