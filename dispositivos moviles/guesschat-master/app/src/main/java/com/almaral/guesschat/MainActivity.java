package com.almaral.guesschat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView chatList = (ListView) findViewById(R.id.chat_list);

        final QuestionAdapter questionAdapter = new QuestionAdapter(this, R.layout.question_adapter_item,
                new ArrayList<ListRow>());

        chatList.setAdapter(questionAdapter);

        final Button sendButton = (Button) findViewById(R.id.send_button);
        final EditText questionEdit = (EditText) findViewById(R.id.question_edit);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndSendQuestion(questionEdit, questionAdapter, chatList);
            }
        });
    }

    private void validateAndSendQuestion(EditText questionEdit, QuestionAdapter questionAdapter, ListView chatList) {
        final String insertedText = questionEdit.getText().toString();

        if (insertedText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Debes insertar una pregunta", Toast.LENGTH_SHORT).show();
        } else {
            questionAdapter.add(new ListRow(insertedText, true));

            final String answer = generateAnswer();

            questionAdapter.add(new ListRow(answer, false));
            questionAdapter.notifyDataSetChanged();

            questionEdit.setText("");
            chatList.setSelection(questionAdapter.getCount() - 1);
        }
    }

    private String generateAnswer() {
        Random random = new Random();

        final int answerId = random.nextInt(5 - 1 + 1) + 1;
        final String answer;

        switch (answerId) {
            case 1:
                answer = "Si";
                break;
            case 2:
                answer = "No";
                break;
            case 3:
                answer = "Pregunta de nuevo";
                break;
            case 4:
                answer = "Es muy probable";
                break;
            case 5:
                answer = "No lo creo";
                break;
            default:
                answer = "No se";
                break;
        }

        return answer;
    }
}
