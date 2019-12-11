package chapter5;

import java.io.Serializable;
import java.util.ArrayList;

// 業務ロジック用のJavaBeans(部品が持つ機能をまとめたクラス) - 主に部品に特化した動詞的要素を定義する
public class StudentInfoBean implements Serializable {
	// 学生レコードのArrayList
    private ArrayList<StudentRecordBean> studentRecordArray = new ArrayList<StudentRecordBean>();

    // Constructor
    public StudentInfoBean() {

    }

    // 学生レコードを取得するメソッド（戻り値がオブジェクトになっている）
    public ArrayList<StudentRecordBean> getStudentRecordArray() {
    	return studentRecordArray;
    }

    // 学生レコードをArrayListに追加するメソッド（引数がオブジェクトになっている）
    public void addStudentRecord(StudentRecordBean obj) {
    	studentRecordArray.add(obj);
    }

    // ArrayListに登録されている学生レコードの件数を返すメソッド
    public int getArraySize() {
    	return studentRecordArray.size();
    }

}
