package hk.ust.cse.comp107x.chatclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muppala on 4/5/15.
 */
public class MyArrayAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    public MyArrayAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View messageView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Current message
        Message message = messages.get(position);
        int layout, timeTextView, messageTextView;
        if (message.fromMe()) {
            // ids used to show message from me
            layout = R.layout.mymessage;
            timeTextView = R.id.mytimeTextView;
            messageTextView = R.id.mymessageTextView;
        } else {
            // ids used to show message to me
            layout = R.layout.message;
            timeTextView = R.id.timeTextView;
            messageTextView = R.id.messageTextView;
        }
        messageView = inflater.inflate(layout, parent, false);
        TextView timeView = (TextView) messageView.findViewById(timeTextView);
        timeView.setText(message.getTime());
        TextView msgView = (TextView) messageView.findViewById(messageTextView);
        msgView.setText(message.getMessage());


        return messageView;
    }
}
