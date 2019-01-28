package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MyController1 {
	@FXML
	private TextField firstDou1;
	@FXML
	private TextField firstDou15;
	@FXML
	private TextField firstDou2;
	@FXML
	private TextField firstDou25;
	@FXML
	private TextField firstDou3;
	@FXML
	private TextField firstZan1;
	@FXML
	private TextField secDou1;
	@FXML
	private TextField secZan1;
	@FXML
	private TextField firstZan15;
	@FXML
	private TextField secDou15;
	@FXML
	private TextField firstZan2;
	@FXML
	private TextField firstZan25;
	@FXML
	private TextField firstZan3;
	@FXML
	private TextField secDou2;
	@FXML
	private TextField secDou25;
	@FXML
	private TextField secDou3;
	@FXML
	private TextField secZan15;
	@FXML
	private TextField secZan2;
	@FXML
	private TextField secZan25;
	@FXML
	private TextField secZan3;
	@FXML
	private TextField douNumber;
	@FXML
	private TextField zanNumber;
	@FXML
	private Button start;
	
	public void eventButton() {
		int dou = Integer.parseInt(douNumber.getText());
		int zan = Integer.parseInt(zanNumber.getText());
		System.out.println(dou + " " + zan);
		
		int fd1 = Integer.parseInt(firstDou1.getText());
		int fd15 = Integer.parseInt(firstDou15.getText());
		int fd2 = Integer.parseInt(firstDou2.getText());
		int fd25 = Integer.parseInt(firstDou25.getText());
		int fd3 = Integer.parseInt(firstDou3.getText());
		
		int sd1 = Integer.parseInt(secDou1.getText());
		int sd15 = Integer.parseInt(secDou15.getText());
		int sd2 = Integer.parseInt(secDou2.getText());
		int sd25 = Integer.parseInt(secDou25.getText());
		int sd3 = Integer.parseInt(secDou3.getText());
		
		int fz1 = Integer.parseInt(firstZan1.getText());
		int fz15 = Integer.parseInt(firstZan15.getText());
		int fz2 = Integer.parseInt(firstZan2.getText());
		int fz25 = Integer.parseInt(firstZan25.getText());
		int fz3 = Integer.parseInt(firstZan3.getText());
		
		int sz1 = Integer.parseInt(secZan1.getText());
		int sz15 = Integer.parseInt(secZan15.getText());
		int sz2 = Integer.parseInt(secZan2.getText());
		int sz25 = Integer.parseInt(secZan25.getText());
		int sz3 = Integer.parseInt(secZan3.getText());
		System.out.println(fd1 + " " + fz1 + " " + sd1 + " " + sz1);
		int[][] matrix = {
				{fd1, fz1, sd1, sz1},
				{fd15, fz15, sd15, sz15},
				{fd2, fz2, sd2, sz2},
				{fd25, fz25, sd25, sz25},
				{fd3, fz3, sd3, sz3}
		};
		double minDouDiff = Integer.MAX_VALUE;
		double minZanDiff = Integer.MAX_VALUE;
		
		int[] resBs = new int[5];
		int[] resJs = new int[5]; 
		
		double maxProfit = Integer.MIN_VALUE;
		
		double b0max = Double.min(dou/matrix[0][0], zan/matrix[0][1]);
		double j0max = Double.min(dou/matrix[0][2], zan/matrix[0][3]);
		double b1max = Double.min(dou/matrix[1][0], zan/matrix[1][1]);
		double j1max = Double.min(dou/matrix[1][2], zan/matrix[1][3]);
		double b2max = Double.min(dou/matrix[2][0], zan/matrix[2][1]);
		double j2max = Double.min(dou/matrix[2][2], zan/matrix[2][3]);
		double b3max = Double.min(dou/matrix[3][0], zan/matrix[3][1]);
		double j3max = Double.min(dou/matrix[3][2], zan/matrix[3][3]);
		double b4max = Double.min(dou/matrix[4][0], zan/matrix[4][1]);
		double j4max = Double.min(dou/matrix[4][2], zan/matrix[4][3]);
		for(int i0=0; i0<b0max; i0++) {
			for(int j0=0; j0<j0max; j0++) {
				double cDou0 = matrix[0][0] * i0 + matrix[0][2] * j0; 
				double cZan0 = matrix[0][1] * i0 + matrix[0][3] * j0;
				if(cDou0 >= dou || cZan0 >= zan) {
					break;
				}
				for(int i1=0; i1<b1max; i1++) {
					for(int j1=0; j1<j1max; j1++) {
						double cDou1 = matrix[0][0] * i0 + matrix[0][2] * j0 + 
									   matrix[1][0] * i1 + matrix[1][2] * j1;
						double cZan1 = matrix[0][1] * i0 + matrix[0][3] * j0 + 
									   matrix[1][1] * i1 + matrix[1][3] * j1;
						if(cDou1 >= dou || cZan1 >= zan) {
							break;
						}
						for(int i2=0; i2<b2max; i2++) {
							for(int j2=0; j2<j2max; j2++) {
								double cDou2 = matrix[0][0] * i0 + matrix[0][2] * j0 + 
											   matrix[1][0] * i1 + matrix[1][2] * j1 + 
											   matrix[2][0] * i2 + matrix[2][2] * j2; 
								double cZan2 = matrix[0][1] * i0 + matrix[0][3] * j0 + 
										   	   matrix[1][1] * i1 + matrix[1][3] * j1 + 
											   matrix[2][1] * i2 + matrix[2][3] * j2; 
								if(cDou2 >= dou || cZan2 >= zan) {
									break;
								}
								for(int i3=0; i3<b3max; i3++) {
									for(int j3=0; j3<j3max; j3++) {
										double cDou3 = matrix[0][0] * i0 + matrix[0][2] * j0 + 
													   matrix[1][0] * i1 + matrix[1][2] * j1 + 
													   matrix[2][0] * i2 + matrix[2][2] * j2 + 
													   matrix[3][0] * i3 + matrix[3][2] * j3;
										double cZan3 = matrix[0][1] * i0 + matrix[0][3] * j0 + 
													   matrix[1][1] * i1 + matrix[1][3] * j1 + 
													   matrix[2][1] * i2 + matrix[2][3] * j2 + 
													   matrix[3][1] * i3 + matrix[3][3] * j3; 
										if(cDou3 >= dou || cZan3 >= zan) {
											break;
										}
										for(int i4=0; i4<b4max; i4++) {
											for(int j4=0; j4<j4max; j4++) {
												int cnt = 0;
												if(i0 != 0) {
													cnt++;
												}
												if(i1 != 0) {
													cnt++;
												}
												if(i2 != 0) {
													cnt++;
												}
												if(i3 != 0) {
													cnt++;
												}
												if(i4 != 0) {
													cnt++;
												}
												if(j0 != 0) {
													cnt++;
												}
												if(j1 != 0) {
													cnt++;
												}
												if(j2 != 0) {
													cnt++;
												}
												if(j3 != 0) {
													cnt++;
												}
												if(j4 != 0) {
													cnt++;
												}
												if(cnt > 2) {
													break;
												}
												double currentDou = matrix[0][0] * i0 + matrix[0][2] * j0 + 
																	matrix[1][0] * i1 + matrix[1][2] * j1 + 
																	matrix[2][0] * i2 + matrix[2][2] * j2 + 
																	matrix[3][0] * i3 + matrix[3][2] * j3 + 
																	matrix[4][0] * i4 + matrix[4][2] * j4;
												double currentZan = matrix[0][1] * i0 + matrix[0][3] * j0 + 
																	matrix[1][1] * i1 + matrix[1][3] * j1 + 
																	matrix[2][1] * i2 + matrix[2][3] * j2 + 
																	matrix[3][1] * i3 + matrix[3][3] * j3 + 
																	matrix[4][1] * i4 + matrix[4][3] * j4;
												if(currentDou <= dou && currentZan <= zan) {
													double profit = i0 * 0.8 * matrix[0][0]*10 + j0 * 0.8 * matrix[0][2]*10 - i0 * matrix[0][0] - j0 * matrix[0][2] - i0 * matrix[0][1] * 5 - j0 * matrix[0][3] * 5 +
															i1 * 0.8 * matrix[0][0]*10 + j1 * 0.8 * matrix[0][2]*10 - i1 * matrix[1][0] - j1 * matrix[1][2] - i1 * matrix[1][1] * 5 - j1 * matrix[1][3] * 5 +
															i2 * 0.8 * matrix[0][0]*10 + j2 * 0.8 * matrix[0][2]*10 - i2 * matrix[2][0] - j2 * matrix[2][2] - i2 * matrix[2][1] * 5 - j2 * matrix[2][3] * 5 +
															i3 * 0.8 * matrix[0][0]*10 + j3 * 0.8 * matrix[0][2]*10 - i3 * matrix[3][0] - j3 * matrix[3][2] - i3 * matrix[3][1] * 5 - j3 * matrix[3][3] * 5;
													
													boolean f = false;
													if(i0 == 0 && i1 == 0 && i2== 0 && i3 == 0 && i4 == 0) {
														if(j0 == 0 && j1 == 0 && j2 == 32 && j3 == 6 && j4 == 0) {
															f = true;
														}
													}
													
													if(zan - currentZan >= 10) {
														break;
													}
													else {
														if(profit > maxProfit) {
															double currDouDiff = dou - currentDou;
															double currZanDiff = zan - currentZan;
															minZanDiff = currZanDiff;
															minDouDiff = currDouDiff;
															maxProfit = profit;
															resBs[0] = i0; 
															resBs[1] = i1; 
															resBs[2] = i2;
															resBs[3] = i3;
															resBs[4] = i4;
															resJs[0] = j0; 
															resJs[1] = j1; 
															resJs[2] = j2;
															resJs[3] = j3;
															resJs[4] = j4;
														}
														else if(profit == maxProfit) {
															if(currentDou < dou && currentZan < zan) {
																double currDouDiff = dou - currentDou;
																double currZanDiff = zan - currentZan;
																if(currZanDiff < minZanDiff) {
																	minZanDiff = currZanDiff;
																	minDouDiff = currDouDiff;
																	resBs[0] = i0; 
																	resBs[1] = i1; 
																	resBs[2] = i2;
																	resBs[3] = i3;
																	resBs[4] = i4;
																	resJs[0] = j0; 
																	resJs[1] = j1; 
																	resJs[2] = j2;
																	resJs[3] = j3;
																	resJs[4] = j4;
																}
																else if(currZanDiff == minZanDiff) {
																	if(currDouDiff < minDouDiff) {
																		minZanDiff = currZanDiff;
																		minDouDiff = currDouDiff;
																		resBs[0] = i0; 
																		resBs[1] = i1; 
																		resBs[2] = i2;
																		resBs[3] = i3;
																		resBs[4] = i4;
																		resJs[0] = j0; 
																		resJs[1] = j1; 
																		resJs[2] = j2;
																		resJs[3] = j3;
																		resJs[4] = j4;
																	}
																}
															}
														}
														else break;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("物品1\t物品2");
		for(int i=0; i<5; i++) {
			System.out.println(resBs[i] + "\t" + resJs[i] + "\t");
		}
		double profit = resBs[0] * 0.8 * matrix[0][0]*10 + resJs[0] * 0.8 * matrix[0][2]*10 - resBs[0] * matrix[0][0] - resJs[0] * matrix[0][2] - resBs[0] * matrix[0][1] * 5 - resJs[0] * matrix[0][3] * 5 +
						resBs[1] * 0.8 * matrix[0][0]*10 + resJs[1] * 0.8 * matrix[0][2]*10 - resBs[1] * matrix[1][0] - resJs[1] * matrix[1][2] - resBs[1] * matrix[1][1] * 5 - resJs[1] * matrix[1][3] * 5 +
						resBs[2] * 0.8 * matrix[0][0]*10 + resJs[2] * 0.8 * matrix[0][2]*10 - resBs[2] * matrix[2][0] - resJs[2] * matrix[2][2] - resBs[2] * matrix[2][1] * 5 - resJs[2] * matrix[2][3] * 5 +
						resBs[3] * 0.8 * matrix[0][0]*10 + resJs[3] * 0.8 * matrix[0][2]*10 - resBs[3] * matrix[3][0] - resJs[3] * matrix[3][2] - resBs[3] * matrix[3][1] * 5 - resJs[3] * matrix[3][3] * 5;
		double proPP = profit / (resBs[0] * matrix[0][0] + resJs[0] * matrix[0][2] + resBs[0] * matrix[0][1] * 5 + resJs[0] * matrix[0][3] * 5 +
								 resBs[1] * matrix[1][0] + resJs[1] * matrix[1][2] + resBs[1] * matrix[1][1] * 5 + resJs[1] * matrix[1][3] * 5 +
								 resBs[2] * matrix[2][0] + resJs[2] * matrix[2][2] + resBs[2] * matrix[2][1] * 5 + resJs[2] * matrix[2][3] * 5 +
								 resBs[3] * matrix[3][0] + resJs[3] * matrix[3][2] + resBs[3] * matrix[3][1] * 5 + resJs[3] * matrix[3][3] * 5 +
								 resBs[4] * matrix[4][0] + resJs[4] * matrix[4][2] + resBs[4] * matrix[4][1] * 5 + resJs[4] * matrix[4][3] * 5);
		System.out.println("剩余豆\t剩余赞\t利润\t利润率");
		System.out.println(minDouDiff + "\t" + minZanDiff + "\t" + profit + "\t" + maxProfit + "\t" + proPP);
		
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("MyScence2.fxml"));
	        AnchorPane root = (AnchorPane) loader.load();
			MyController2 msc = loader.getController();
			msc.setFirstNum1(String.valueOf(resBs[0]));
			msc.setFirstNum15(String.valueOf(resBs[1]));
			msc.setFirstNum2(String.valueOf(resBs[2]));
			msc.setFirstNum25(String.valueOf(resBs[3]));
			msc.setFirstNum3(String.valueOf(resBs[4]));
			
			msc.setSecNum1(String.valueOf(resJs[0]));
			msc.setSecNum15(String.valueOf(resJs[1]));
			msc.setSecNum2(String.valueOf(resJs[2]));
			msc.setSecNum25(String.valueOf(resJs[3]));
			msc.setSecNum3(String.valueOf(resJs[4]));
			
			msc.setLeftDou(String.valueOf(minDouDiff));
			msc.setLeftZan(String.valueOf(minZanDiff));
			
			msc.setProfit(String.valueOf(profit));
			msc.setProPP(String.valueOf(proPP));
			
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
	        primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
