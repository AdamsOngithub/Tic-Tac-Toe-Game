
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{

    JPanel textPanel =new JPanel();
    JPanel buttonsPanel= new JPanel();
    JLabel text=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean isPlayerOne=true;
    Random random=new Random();

    MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.getContentPane().setBackground(new Color(50,50,50));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        //Text style
        text.setBackground(new Color(25,25,25));
        text.setForeground(new Color(25,255,0));
        text.setFont(new Font("Nordic Light",Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
        text.setOpaque(true);
        
        //Text container
        textPanel.setLayout(new BorderLayout());
        textPanel.setBounds(0,0,800,100);
        textPanel.add(text);
        
        //Buttons container
        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(125,125,125));
        
        //add buttons to the buttonsPanel
        
        for(int i=0; i<9; i++){
            buttons[i]=new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
        }
        
        this.add(textPanel,BorderLayout.NORTH);
        this.add(buttonsPanel);
        Play(); 

    }

        public void checkWin(){
        //check all the possiblity of Player x is winnig 
        if(     ("X".equals(buttons[0].getText()))&&
                ("X".equals(buttons[1].getText()))&&
                ("X".equals(buttons[2].getText()))){
            xWins(0,1,2);
        }
        if(     ("X".equals(buttons[3].getText()))&&
                ("X".equals(buttons[4].getText()))&&
                ("X".equals(buttons[5].getText()))){
            xWins(3,4,5);
        }
        if(     ("X".equals(buttons[6].getText()))&&
                ("X".equals(buttons[7].getText()))&&
                ("X".equals(buttons[8].getText()))){
            xWins(6,7,8);
        }
        if(     ("X".equals(buttons[0].getText()))&&
                ("X".equals(buttons[3].getText()))&&
                ("X".equals(buttons[6].getText()))){
            xWins(0,3,6);
        }
        if(     ("X".equals(buttons[1].getText()))&&
                ("X".equals(buttons[4].getText()))&&
                ("X".equals(buttons[7].getText()))){
            xWins(1,4,7);
        }
        if(     ("X".equals(buttons[2].getText()))&&
                ("X".equals(buttons[5].getText()))&&
                ("X".equals(buttons[8].getText()))){
            xWins(2,5,8);
        }
        if(     ("X".equals(buttons[0].getText()))&&
                ("X".equals(buttons[4].getText()))&&
                ("X".equals(buttons[8].getText()))){
            xWins(0,4,8);
        }

        if(     ("X".equals(buttons[2].getText()))&&
                ("X".equals(buttons[4].getText()))&&
                ("X".equals(buttons[6].getText()))){
            xWins(2,4,6);
        }
        //check all the possiblity of Player x is winnig 
        if(     ("O".equals(buttons[0].getText()))&&
                ("O".equals(buttons[1].getText()))&&
                ("O".equals(buttons[2].getText()))){
            oWins(0,1,2);
        }
        if(     ("O".equals(buttons[3].getText()))&&
                ("O".equals(buttons[4].getText()))&&
                ("O".equals(buttons[5].getText()))){
            oWins(3,4,5);
        }
        if(     ("O".equals(buttons[6].getText()))&&
                ("O".equals(buttons[7].getText()))&&
                ("O".equals(buttons[8].getText()))){
            oWins(6,7,8);
        }
        if(     ("O".equals(buttons[0].getText()))&&
                ("O".equals(buttons[3].getText()))&&
                ("O".equals(buttons[6].getText()))){
            oWins(0,3,6);
        }
        if(     ("O".equals(buttons[1].getText()))&&
                ("O".equals(buttons[4].getText()))&&
                ("O".equals(buttons[7].getText()))){
            oWins(1,4,7);
        }
        if(     ("O".equals(buttons[2].getText()))&&
                ("O".equals(buttons[5].getText()))&&
                ("O".equals(buttons[8].getText()))){
            oWins(2,5,8);
        }
        if(     ("O".equals(buttons[0].getText()))&&
                ("O".equals(buttons[4].getText()))&&
                ("O".equals(buttons[8].getText()))){
            oWins(0,4,8);
        }

        if(     ("O".equals(buttons[2].getText()))&&
                ("O".equals(buttons[4].getText()))&&
                ("O".equals(buttons[6].getText()))){
            oWins(2,4,6);
        }
    }
    
    public void Play(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            
        }
        if(random.nextInt(2)==0){
                isPlayerOne=true;
                text.setText("X Player");
        }else{
                isPlayerOne=false;
                text.setText("O Player");
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(isPlayerOne){
                    if("".equals(buttons[i].getText())){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        isPlayerOne=false;
                        text.setText("O Player Turn");
                        checkWin();
                    }
                }
                else{
                    if("".equals(buttons[i].getText())){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        isPlayerOne=true;
                        text.setText("X Player Turn");
                        checkWin();
                    }
                }
            }
        }
    }
    

    private void xWins(int x, int y, int z) {
        buttons[x].setBackground(Color.GREEN);
        buttons[y].setBackground(Color.GREEN);
        buttons[z].setBackground(Color.GREEN);
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    private void oWins(int x, int y, int z) {
        buttons[x].setBackground(Color.GREEN);
        buttons[y].setBackground(Color.GREEN);
        buttons[z].setBackground(Color.GREEN);
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }
    
}
