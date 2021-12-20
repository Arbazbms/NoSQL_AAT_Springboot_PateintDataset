package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coll")
public class Patient {
	
	@Id
	private String id;
	
	private int Age;
	private String Sex;
	private String ChestPainType;
	private int RestingBP;
	private int Cholesterol;
	private int FastingBS;
	private String RestingECG;
	private int MaxHR;
	private String ExerciseAngina;
	private int Oldpeak;
	private String ST_Slope;
	private int HeartDisease;
	

	

	public Patient(int age, String sex, String chestPainType, int restingBP, int cholesterol, int fastingBS,
			String restingECG, int maxHR, String exerciseAngina, int oldpeak, String sT_Slope, int heartDisease) {
		super();
		Age = age;
		Sex = sex;
		ChestPainType = chestPainType;
		RestingBP = restingBP;
		Cholesterol = cholesterol;
		FastingBS = fastingBS;
		RestingECG = restingECG;
		MaxHR = maxHR;
		ExerciseAngina = exerciseAngina;
		Oldpeak = oldpeak;
		ST_Slope = sT_Slope;
		HeartDisease = heartDisease;
	}


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getSex() {
		return Sex;
	}


	public void setSex(String sex) {
		Sex = sex;
	}


	public String getChestPainType() {
		return ChestPainType;
	}


	public void setChestPainType(String chestPainType) {
		ChestPainType = chestPainType;
	}


	public int getRestingBP() {
		return RestingBP;
	}


	public void setRestingBP(int restingBP) {
		RestingBP = restingBP;
	}


	public int getCholesterol() {
		return Cholesterol;
	}


	public void setCholesterol(int cholesterol) {
		Cholesterol = cholesterol;
	}


	public int getFastingBS() {
		return FastingBS;
	}


	public void setFastingBS(int fastingBS) {
		FastingBS = fastingBS;
	}


	public String getRestingECG() {
		return RestingECG;
	}


	public void setRestingECG(String restingECG) {
		RestingECG = restingECG;
	}


	public int getMaxHR() {
		return MaxHR;
	}


	public void setMaxHR(int maxHR) {
		MaxHR = maxHR;
	}


	public String getExerciseAngina() {
		return ExerciseAngina;
	}


	public void setExerciseAngina(String exerciseAngina) {
		ExerciseAngina = exerciseAngina;
	}


	public int getOldpeak() {
		return Oldpeak;
	}


	public void setOldpeak(int oldpeak) {
		Oldpeak = oldpeak;
	}


	public String getST_Slope() {
		return ST_Slope;
	}


	public void setST_Slope(String sT_Slope) {
		ST_Slope = sT_Slope;
	}


	public int getHeartDisease() {
		return HeartDisease;
	}


	public void setHeartDisease(int heartDisease) {
		HeartDisease = heartDisease;
	}
	
	
}
