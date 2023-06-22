package javaproject.portfolio.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import javaproject.portfolio.DTO.PortFolio;

public class PrintExcel {
	PortfolioPage portfolioPage;

	public PrintExcel(PortfolioPage portfolioPage) {
		this.portfolioPage = portfolioPage;
	}

	public void printPortfolio() {
		int result = portfolioPage.chooser.showSaveDialog(portfolioPage);
		if (result != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File file = portfolioPage.chooser.getSelectedFile();
		String path = file.getAbsolutePath();

		HSSFWorkbook book = new HSSFWorkbook();
		// 폰트설정
		Font font = book.createFont();
		font.setFontName("맑은고딕");
		font.setFontHeight((short) 260);
		font.setBoldweight((short) 500);

		// 셀 스타일 적용
		CellStyle defaultStyle = book.createCellStyle();

		defaultStyle.setFont(font);

		// 셀 가운데 정렬
		defaultStyle.setWrapText(true);
		defaultStyle.setAlignment(CellStyle.ALIGN_CENTER);

		HSSFSheet sheet = book.createSheet("금융상품 포트폴리오");
		// sheet.setDisplayGridlines(false);

		HSSFRow row = sheet.createRow(0);

		sheet.setDefaultRowHeightInPoints(3000);
		sheet.setDefaultColumnWidth(3000);

		for (int i = 0; i < 3; i++) {// 제목이 될 row
			HSSFRow titleRow = sheet.createRow(i);

			for (int j = 0; j < 10; j++) {
				HSSFCell titleCell = titleRow.createCell(j);
				titleCell.setCellStyle(defaultStyle);
				titleCell.setCellValue("금융상품 포트폴리오");

				sheet.setColumnWidth(i, 3000);
			}
		}
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 9));

		HSSFRow row2 = sheet.getRow(2);
		HSSFCell cell2 = row2.getCell(0);

		defaultStyle.setWrapText(true);
		cell2.setCellStyle(defaultStyle);

		String[] columnName = { "은행이름", "상품이름", "원금합계", "세후이자" };
		HSSFRow rowBankinfo = sheet.createRow(6);
		for (int i = 0; i < columnName.length; i++) {
			HSSFCell cell = rowBankinfo.createCell(i);
			cell.setCellValue(columnName[i]);

			sheet.setDefaultColumnWidth(10);
		}

		for (int i = 0; i < portfolioPage.model.list.size(); i++) {
			// 이제, list에서 DTO하나씩 꺼내서 각 셀에 넣어주기
			PortFolio portFolio = portfolioPage.model.list.get(i);

			HSSFRow record = sheet.createRow(i + 7);
			HSSFCell bank_name = record.createCell(0);
			HSSFCell product_name = record.createCell(1);
			HSSFCell amount = record.createCell(2);
			HSSFCell irat = record.createCell(3);

			bank_name.setCellValue(portFolio.getBank_name());
			product_name.setCellValue(portFolio.getProduct_name());
			amount.setCellValue(portFolio.getTotalAmount());
			irat.setCellValue(portFolio.getIrat());
		}

		HSSFRow rowPeriod = sheet.createRow(portfolioPage.model.list.size() + 8);
		String[] columnName2 = { "1개월", "3개월", "6개월", "1년", "2년", "3년", "총합" };

		for (int i = 0; i < columnName2.length; i++) {
			HSSFCell cell = rowPeriod.createCell(i);
			cell.setCellValue(columnName2[i]);
		}

		for (int a = 0; a < 7; a++) {
			HSSFRow record = sheet.createRow(portfolioPage.model.list.size() + 9);
			HSSFCell mm1 = record.createCell(0);
			HSSFCell mm3 = record.createCell(1);
			HSSFCell mm6 = record.createCell(2);
			HSSFCell yy1 = record.createCell(3);
			HSSFCell yy2 = record.createCell(4);
			HSSFCell yy3 = record.createCell(5);
			HSSFCell total = record.createCell(6);

			mm1.setCellValue(portfolioPage.t_1mm.getText());
			mm3.setCellValue(portfolioPage.t_3mm.getText());
			mm6.setCellValue(portfolioPage.t_6mm.getText());
			yy1.setCellValue(portfolioPage.t_1yy.getText());
			yy2.setCellValue(portfolioPage.t_2yy.getText());
			yy3.setCellValue(portfolioPage.t_3yy.getText());
			total.setCellValue(portfolioPage.t_total.getText());

		}
		try {
			String filePath = "C:/java_workspace2/NetworkApp/name_chart.png";
			InputStream is = new FileInputStream(filePath);
			byte[] bytes = IOUtils.toByteArray(is);
			int picIdx = book.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_PNG);
			is.close();
			HSSFCreationHelper helper = (HSSFCreationHelper) book.getCreationHelper();
			HSSFPatriarch drawing = sheet.createDrawingPatriarch();
			HSSFClientAnchor anchor = helper.createClientAnchor();

			anchor.setCol1(7); 
			anchor.setRow1(5);
			anchor.setCol2(9);
			anchor.setRow2(12);
			
			anchor.setDx1(0);
			anchor.setDx2(3000);
			anchor.setDy1(0);
			anchor.setDy2(3000);

			HSSFPicture pic = drawing.createPicture(anchor, picIdx);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileOutputStream fos = null;
		System.out.println(fos);
		try {
			fos = new FileOutputStream(file);
			System.out.println(file);
			book.write(fos);
			JOptionPane.showMessageDialog(portfolioPage, "엑셀파일 저장완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
