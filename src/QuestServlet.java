import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Stas on 25.08.2016.
 */
public class QuestServlet extends HttpServlet {
    static final int Question_1_yes = 0;
    static final int Question_1_no = 1;
    static final int Question_2_yes = 2;
    static final int Question_2_no = 3;
    static final int Question_3_yes = 4;
    static final int Question_3_no = 5;
    static final String TEMPLATE = "<html>" +
            "<head><title>Анкета</title></head>" +
            "<body><h1>%s</h1></body></html>";
    final  int[] results = new int[6];
    public void  doPost (HttpServletRequest reg, HttpServletResponse resp) throws IOException {
        final String q1 = reg.getParameter("option1");
        final String q2 = reg.getParameter("option2");
        final String q3 = reg.getParameter("option3");

        final  int idx1 = "Yes".equals(q1) ? Question_1_yes : Question_1_no;
        final  int idx2 = "Yes".equals(q2) ? Question_2_yes : Question_2_no;
        final  int idx3 = "Yes".equals(q3) ? Question_3_yes : Question_3_no;

        results[idx1]++;
        results[idx2]++;
        results[idx3]++;
        String res = "<p>Question 1: yes = " + results[Question_1_yes] + " , no = " + results[Question_1_no]+ "</p>";


        resp.getWriter().println(String.format(TEMPLATE, res));
    }
}
