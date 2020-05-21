package com.perval.levi.ayuda;

import androidx.appcompat.app.AppCompatActivity;
import com.perval.levi.R;

import android.os.Bundle;
import android.widget.TextView;

public class EulaActivity extends AppCompatActivity {
    private TextView Texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);


        Texto1 = (TextView) findViewById(R.id.TVEula);
        String EULATEXT2 ="THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. " +
                "IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR " +
                "OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, " +
                "ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.";

        Texto1.setText(EULATEXT2);
    }


}
