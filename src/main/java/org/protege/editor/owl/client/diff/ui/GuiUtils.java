package org.protege.editor.owl.client.diff.ui;

import org.protege.editor.owl.client.diff.model.ChangeMode;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class GuiUtils {

    /* constants */

    public static final Color
            ADDITION_COLOR = new Color(219, 253, 217),
            REMOVAL_COLOR = new Color(255, 221, 220),
            ONTOLOGY_IRI_COLOR = new Color(242, 248, 255),
            DEFAULT_CHANGE_COLOR = new Color(252, 249, 232),
            WHITE_BACKGROUND = Color.WHITE,
            UNSELECTED_FOREGROUND = Color.BLACK,
            BORDER_COLOR = new Color(220, 220, 220);

    public static final Border
            MATTE_BORDER = new MatteBorder(1, 1, 1, 1, BORDER_COLOR),
            EMPTY_BORDER = new EmptyBorder(0,0,0,0);

    public static final String
            USER_ICON_FILENAME = "user.png",
            USERS_ICON_FILENAME = "users.png",
            COMMIT_ICON_FILENAME = "commit.png",
            STRING_ICON_FILENAME = "string.png",
            ONTOLOGY_ICON_FILENAME = "ontology.png",
            WARNING_ICON_FILENAME = "warning.png",
            REVIEW_ACCEPTED_ICON_FILENAME = "review-accepted.png",
            REVIEW_REJECTED_ICON_FILENAME = "review-rejected.png",
            REVIEW_CLEAR_ICON_FILENAME = "review-clear.png",
            REVIEW_COMMIT_ICON_FILENAME = "review-commit.png",
            REVIEW_PENDING_ICON_FILENAME = "review-pending.png",
            NEW_REVIEW_ICON_FILENAME = "review-new.png";


    /* methods */

    public static Icon getIcon(String filename, int width, int height) {
        BufferedImage icon = null;
        ClassLoader classLoader = GuiUtils.class.getClassLoader();
        try {
            icon = ImageIO.read(checkNotNull(classLoader.getResource(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image img = icon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static void setComponentBackground(Component c, ChangeMode mode) {
        switch(mode) {
            case ADDITION:
                c.setBackground(ADDITION_COLOR); break;
            case REMOVAL:
                c.setBackground(REMOVAL_COLOR); break;
            case ONTOLOGY_IRI:
                c.setBackground(ONTOLOGY_IRI_COLOR); break;
            case ALIGNED:
            case CUSTOM:
            default:
                c.setBackground(DEFAULT_CHANGE_COLOR); break;
        }
    }

    public static String getFormattedDate(Date date) {
        return new SimpleDateFormat("EEE, MMM d yyyy HH:mm").format(date);
    }

    public static String getShortenedFormattedDate(Date date) {
        return new SimpleDateFormat("MMM d yyyy HH:mm").format(date);
    }
}
