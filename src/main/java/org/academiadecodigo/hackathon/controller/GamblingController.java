package org.academiadecodigo.hackathon.controller;

        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Menu;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TextField;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import org.academiadecodigo.hackathon.Navigation;
        import org.academiadecodigo.hackathon.service.UserService;

public class GamblingController implements Controller {

    Image[] image = new Image[4];



    private static final String NAME = "gambling";

    private UserService userService;

    private Navigation navigation;

    @FXML
    private Menu menu;

    @FXML
    private MenuItem logoutMenu;

    @FXML
    private MenuItem closeMenu;

    @FXML
    private TextField bet;

    @FXML
    private Button tryButton;

    @FXML
    private ImageView roulette0;

    @FXML
    private ImageView roulette1;

    @FXML
    private ImageView roulette2;

    @FXML
    private ImageView roulette3;

    @FXML
    private Button quitButton;

    ImageView[] imageViews = new ImageView[4];


    public GamblingController(UserService userService, Navigation navigation){
        this.userService = userService;
        this.navigation = navigation;
    }

    public void initialize() {

            imageViews[0] = roulette0;
            imageViews[1] = roulette1;
            imageViews[2] = roulette2;
            imageViews[3] = roulette3;

            setNotVisible((int)Math.round(Math.random() * 2));

    }

    @FXML
    void placeBet(MouseEvent event) {

        int result= 0;

        if (userService.getCurrentUser().getWallet().getcAmount() < Double.parseDouble(bet.getText())){

            return;

        }

        for (int i = 0; i < Math.round((Math.random()+5) * 11); i++) {

            int n = (int)Math.round(Math.random() * 3);

            setNotVisible(n);

        }

        for (int i = 0; i < imageViews.length; i++) {

            if (imageViews[i].isVisible()){

                result = i;
                break;

            }

        }

        switch (result){

            case 0:
                win(2);
                break;
            case 1:
                win(3);
                break;
            case 2:
                loose();
                break;
            case 3:
                win(100);
                break;

        }

    }

    @FXML
    void quitBet(MouseEvent event) {
        navigation.back();
    }

    private void setNotVisible(int n){

        for (int i = 0; i < imageViews.length; i++) {

            if (n == i){
                imageViews[i].setVisible(true);
            }
            else {

                imageViews[i].setVisible(false);

            }

        }

    }

    public void win(int result){


        userService.getCurrentUser().getWallet().setcAmount(userService.getCurrentUser().getWallet().getdAmount()*result);

    }

    public void loose(){

        userService.getCurrentUser().getWallet().setcAmount(userService.getCurrentUser().getWallet().getdAmount()-Double.parseDouble(bet.getText()));

    }

}

