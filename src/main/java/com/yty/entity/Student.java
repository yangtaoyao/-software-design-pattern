package com.yty.entity;

/**
 * 建造者模式
 * Student.builder().grade("grade").schoolName("schoolName").build();
 */
public class Student {

    private String schoolName;
    private String grade;

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder{
        private Student student;

        public Builder(){
            this.student = new Student();
        }

        public Builder schoolName(String schoolName){
            student.schoolName = schoolName;
            return this;
        }

        public Builder grade(String grade){
            student.grade = grade;
            return this;
        }

        public Student build(){
            return student;
        }

    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
