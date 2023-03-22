package com.prototype.factory;

import com.prototype.factory.entity.AnswerQuestion;
import com.prototype.factory.entity.ChoiceQuestion;
import com.prototype.factory.util.Topic;
import com.prototype.factory.util.TopicRandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * 题库类：主要负责将各个题目进行组装最终输出试卷。
 * 克隆对象处理类
 */
public class QuestionBank implements Cloneable{
    private String candidate;   //考生
    private String number;  // 考号

    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<ChoiceQuestion>();
    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<AnswerQuestion>();


    public QuestionBank append(ChoiceQuestion choiceQuestion){
        choiceQuestions.add(choiceQuestion);
        return this;
    }

    public QuestionBank append(AnswerQuestion answerQuestion){
        answerQuestions.add(answerQuestion);
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestions = (ArrayList<ChoiceQuestion>) choiceQuestions.clone();
        questionBank.answerQuestions = (ArrayList<AnswerQuestion>) answerQuestions.clone();
        //题目乱序
        Collections.shuffle(questionBank.answerQuestions);
        Collections.shuffle(questionBank.choiceQuestions);

        //答案乱序
        ArrayList<ChoiceQuestion> choiceQuestions = questionBank.choiceQuestions;
        for (ChoiceQuestion choiceQuestion : choiceQuestions) {
            Topic random = TopicRandomUtil.random(choiceQuestion.getOption(), choiceQuestion.getKey());
            choiceQuestion.setOption(random.getOption());
            choiceQuestion.setKey(random.getKey());
        }
        return questionBank;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n"
                + "考号：" + number +"\r\n" +
                "--------------------------------\r\n"
                +"一、选择题" + "\r\n\n");

        for (int i = 0; i < choiceQuestions.size(); i++) {
            detail.append("第").append(i +1).append("题：").append(choiceQuestions.get(i)
                    .getName()).append("\r\n");

            Map<String, String> option = choiceQuestions.get(i).getOption();

            for (String key : option.keySet()) {
                detail.append(key).append(":").append(option.get(key)).append("\r\n\n");
            }

            detail.append("答案：").append(choiceQuestions.get(i).getKey()).append("\r\n\n");
        }

        detail.append("二、问答题"+"\r\n\n");

        for (int idx = 0; idx < answerQuestions.size(); idx++) {
            detail.append("第").append(idx +1).append("题：").append(answerQuestions.get(idx).getName()).append("\r\n\n");

            detail.append("答案：").append(answerQuestions.get(idx).getKey()).append("\r\n\n");
        }
        return detail.toString();
    }
}
