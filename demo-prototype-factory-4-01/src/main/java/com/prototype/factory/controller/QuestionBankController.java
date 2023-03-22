package com.prototype.factory.controller;

import com.prototype.factory.QuestionBank;
import com.prototype.factory.entity.AnswerQuestion;
import com.prototype.factory.entity.ChoiceQuestion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型模式：便于通过克隆方式创建复杂对象、也可以避免重复做初始化操作
 * 不需要与类中所属的其他类耦合等。
 */


@RestController
@Api(tags = "原型模式")
public class QuestionBankController {
    private QuestionBank questionBank = new QuestionBank();

    public QuestionBankController(){
        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");
        Map<String, String> map02 = new HashMap<String, String>();
        map02.put("A", "JAVA程序的main⽅法必须写在类⾥面");
        map02.put("B", "JAVA程序中可以有多个main⽅方法");
        map02.put("C", "JAVA程序中类名必须与⽂文件名一样");
        map02.put("D", "JAVA程序的main⽅方法中如果只有一条语句，可以不用{}(⼤括号)括起来");
        Map<String, String> map03 = new HashMap<String, String>();
        map03.put("A", "变量由字⺟、下划线、数字、$符号随意组成；");
        map03.put("B", "变量不能以数字作为开头；");
        map03.put("C", "A和a在java中是同一个变量；");
        map03.put("D", "不不同类型的变量，可以起相同的名字；");
        Map<String, String> map04 = new HashMap<String, String>();
        map04.put("A", "STRING");
        map04.put("B", "x3x;");
        map04.put("C", "void");
        map04.put("D", "de$f");
        Map<String, String> map05 = new HashMap<String, String>();
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        questionBank.append(new ChoiceQuestion("JAVA所定义的版本中不包括", map01, "D"));
        questionBank.append(new ChoiceQuestion("下列说法正确的是", map02, "A"));
        questionBank.append(new ChoiceQuestion("变量命名规范说法正确的是", map03, "B"));
        questionBank.append(new ChoiceQuestion("以下()不是合法的标识符", map04, "C"));
        questionBank.append(new ChoiceQuestion("表达式(11+3*8)/4%3的值是", map05, "D"));
        questionBank.append(new AnswerQuestion("小红马和小黑马生的小马几条腿", "4条腿"));
        questionBank.append(new AnswerQuestion("铁棒打头疼还是木棒打头疼", "头最疼"));
        questionBank.append(new AnswerQuestion("什么床不能睡觉", "牙床"));
        questionBank.append(new AnswerQuestion("为什么好马不吃回头草", "后面的草没了"));

    }

    @PostMapping("/createPaper")
    @ApiOperation(value = "cretePaper", tags = "生成试卷")
    public String createPaper(String candidate, String number) throws CloneNotSupportedException{
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);
        return questionBankClone.toString();

    }
}
