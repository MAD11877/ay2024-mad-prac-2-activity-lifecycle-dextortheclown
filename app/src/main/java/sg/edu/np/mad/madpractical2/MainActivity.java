package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean followed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initialise user
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get textviews and button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDesc = findViewById(R.id.description);
        Button btnFollow = findViewById(R.id.Button1);

        tvName.setText(user.name);
        tvDesc.setText(user.description);
        btnFollow.setText("Follow");


        btnFollow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "follow button pressed");

                // Toggle text and update followed variable
                if (followed) {
                    btnFollow.setText("Follow");
                } else {
                    btnFollow.setText("Unfollow");
                }
                followed = !followed;
            }
        });

    }
}