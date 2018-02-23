import com.sun.tools.javac.Main
import java.awt.*
import java.util.stream.IntStream.range
import javax.swing.*


//open class MainActivity {

// Create a visible frame
fun main(args: Array<String>) {
    val frame = JFrame("Charting Program")
    //Set frame size and allow it to be resized.
    frame.isResizable = true
    //Set close operation to close the application.
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    //Create a label for the drop down menu.
    val attendanceLabel = JLabel("Attendance:")
    //Set label to visible.
    attendanceLabel.isVisible = true

    //COMBO BOX
    //Create a drop down combo box for the groups.
    val groupListComboBox: JComboBox<String> = JComboBox()

    val groupHashMap: HashMap<Int, String> = hashMapOf()

    val dropDownListItems = listOf("Anger Management", "Art Therapy/Feelings", "Awareness", "Co-Occuring", "Communication Skills",
            "Coping Skills", "Discharge Game", "Emotions", "Empowerment", "Fitness Facts", "Goals", "Impulse Control", "Jenga",
            "Leisure Education", "Life Skills Game", "Masking", "Mindfulness", "Needs vs Wants", "Nutrition", "Problem Solving",
            "Relaxation/Stress Management", "Self-Esteem", "Time Management", "Values", "Wellness")

    for (i in dropDownListItems) {
        with(groupHashMap) {
            put(key = dropDownListItems.indexOf(i), value = i)
        }
    }

    for (i in range(0, groupHashMap.size)) {
        groupListComboBox.addItem(groupHashMap[i])
    }

//        println(groupHashMap)
//        println(groupHashMap[0])

    /*
--------------------- NORTH PANEL ------------------------
*/
    //Create the northern panel and specify it be a flow layout.
    val northPanel = JPanel(FlowLayout(FlowLayout.LEFT))

    //Add the panel to the frame and specify it cover the north area of the frame layout.
    frame.add(northPanel, "North")

    //Add the groupListHashMap to the north panel.
    northPanel.add(groupListComboBox)
    //Add the attendance label to the panel
    northPanel.add(attendanceLabel)
    //Add the drop down to the panel

    //NORTH PANEL RADIO BUTTONS
    //Create 6x radio buttons for different group durations.
    val didNotAttend = JRadioButton("Did Not Attend", true)
    val fifteenMinRadioButton = JRadioButton("15 Minutes")
    val thirtyMinRadioButton = JRadioButton("30 Minutes")
    val fortyFiveMinRadioButton = JRadioButton("45 Minutes")
    val sixtyMinRadioButton = JRadioButton("60 Minutes")
    val entireGroupRadioButton = JRadioButton("Entire Group Duration")

    //Create an array of jradio buttons for loops.
    val JRadioButtonList = arrayOf<JRadioButton>(didNotAttend, fifteenMinRadioButton, thirtyMinRadioButton, fortyFiveMinRadioButton, sixtyMinRadioButton, entireGroupRadioButton)

    //Create an empty button group.
    val radioButtonGroup = ButtonGroup()

    // For each radio button in the list, add it to the north panel (flow layout)
    // Once they are all added, then add all radio buttons to the group.
    for (x in JRadioButtonList) {
        northPanel.add(x)
        run { radioButtonGroup.add(x) }
    }
    northPanel.isVisible = true
    northPanel.border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createLineBorder(Color.CYAN, 4))
    groupListComboBox.border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createLineBorder(Color.CYAN, 1))

    /*
------------------ EAST PANEL -----------------
*/
    //Create a button for submission.
    val eastPanel = JPanel()
    eastPanel.layout = BoxLayout(eastPanel, BoxLayout.Y_AXIS)

    val resetButton = JButton("Reset  ")
    resetButton.isVisible = true
    eastPanel.add(resetButton)

    val submitButton = JButton("Submit")
    submitButton.isVisible = true
    eastPanel.add(submitButton)

    //Add the button to the panel.
    frame.add(eastPanel, "East")
    eastPanel.isVisible = true
    /*
----------------- SOUTH PANEL -------------
*/
    val output = TextArea()
    frame.add(output, "South")

    /*
----------------- CENTER PANEL ------------
*/
    //Create a new jpanel with flow layout to hold the affect tick boxes.
    val centerPanel = JPanel(GridLayout(9, 10))
    frame.add(centerPanel)
    centerPanel.isVisible = true

    //A
    val agitatedCheckBox = JCheckBox("Agitated")
    val angryCheckBox = JCheckBox("Angry")
    val animatedCheckBox = JCheckBox("Animated")
    val anxiousCheckBox = JCheckBox("Anxious")
    val apprehensiveCheckBox = JCheckBox("Apprehensive")
    val appropriateCheckBox = JCheckBox("Appropriate")
    //B
    val belligerentCheckBox = JCheckBox("Belligerent")
    val blandCheckBox = JCheckBox("Bland")
    val bluntedCheckBox = JCheckBox("Blunted")
    val brightCheckBox = JCheckBox("Bright")
    //C
    val calmCheckBox = JCheckBox("Calm")
    val cheerfulCheckBox = JCheckBox("Cheerful")
    val comfortableCheckBox = JCheckBox("Comfortable")
    val composedCheckBox = JCheckBox("Composed")
    val constrictedCheckBox = JCheckBox("Constricted")
    val controlledCheckBox = JCheckBox("Controlled")
    //D
    val dazedCheckBox = JCheckBox("Dazed")
    val dejectedCheckBox = JCheckBox("Dejected")
    val depressedCheckBox = JCheckBox("Depressed")
    val despondentCheckBox = JCheckBox("Despondent")
    val disappointedCheckBox = JCheckBox("Disappointed")
    //E
    val eagerCheckBox = JCheckBox("Eager")
    val elevatedCheckBox = JCheckBox("Elevated")
    val energeticCheckBox = JCheckBox("Energetic")
    val enthusiasticCheckBox = JCheckBox("Enthusiastic")
    val euphoricCheckBox = JCheckBox("Euphoric")
    val exhilaratedCheckBox = JCheckBox("Exhilarated")
    //F
    val fearfulCheckBox = JCheckBox("Fearful")
    val fixed_expressionCheckBox = JCheckBox("Fixed Expression")
    val flatCheckBox = JCheckBox("Flat")
    val frightenedCheckBox = JCheckBox("Frightened")
    val frustratedCheckBox = JCheckBox("Frustrated")
    //G
    val guardedCheckBox = JCheckBox("Guarded")
    val guiltyCheckBox = JCheckBox("Guilty")

    val happyCheckBox = JCheckBox("Happy")
    val hopelessCheckBox = JCheckBox("Hopeless")
    val hostileCheckBox = JCheckBox("Hostile")

    val indignantCheckBox = JCheckBox("Indignant")
    val interestedCheckBox = JCheckBox("Interested")
    val irritableCheckBox = JCheckBox("Irritable")

    val labileCheckBox = JCheckBox("Labile")
    val lacking_energyCheckBox = JCheckBox("Lacking Energy")

    val matter_of_fact_CheckBox = JCheckBox("Matter-of-Fact")
    val motivatedCheckBox = JCheckBox("Motivated")

    val nonchalantCheckBox = JCheckBox("Nonchalant")

    val overwhelmedCheckBox = JCheckBox("Overwhelmed")

    val panickyCheckBox = JCheckBox("Panicky")
    val placidCheckBox = JCheckBox("Placid")
    val powerlessCheckBox = JCheckBox("Powerless")
    val pressuredCheckBox = JCheckBox("Pressured")
    val puzzledCheckBox = JCheckBox("Puzzled")

    val relaxedCheckBox = JCheckBox("Relaxed")
    val remorsefulCheckBox = JCheckBox("Remorseful")
    val resentfulCheckBox = JCheckBox("Resentful")

    val sadCheckBox = JCheckBox("Sad")
    val scowlingCheckBox = JCheckBox("Scowling")
    val self_criticalCheckBox = JCheckBox("Self-Critical")
    val self_deprectaroyCheckBox = JCheckBox("Self-Deprecatory")
    val self_effacingCheckBox = JCheckBox("Self-Effacing")
    val seriousCheckBox = JCheckBox("Serious")
    val smilingCheckBox = JCheckBox("Smiling")
    val soberCheckBox = JCheckBox("Sober")
    val spontaneousCheckBox = JCheckBox("Spontaneous")
    val staringCheckBox = JCheckBox("Staring")
    val subduedCheckBox = JCheckBox("Subdued")
    val sullenCheckBox = JCheckBox("Sullen")
    val superficialCheckBox = JCheckBox("Superficial")
    val suspiciousCheckBox = JCheckBox("Suspicious")

    val tearfulCheckBox = JCheckBox("Tearful")
    val tenseCheckBox = JCheckBox("Tense")

    val unhappyCheckBox = JCheckBox("Unhappy")


    val toDoCheckBoxList = arrayOf<JCheckBox>(agitatedCheckBox, angryCheckBox, animatedCheckBox, anxiousCheckBox,
            apprehensiveCheckBox, appropriateCheckBox, belligerentCheckBox, blandCheckBox, bluntedCheckBox,
            brightCheckBox, calmCheckBox, cheerfulCheckBox, comfortableCheckBox, composedCheckBox, constrictedCheckBox,
            controlledCheckBox, dazedCheckBox, dejectedCheckBox, depressedCheckBox, despondentCheckBox,
            disappointedCheckBox, eagerCheckBox, elevatedCheckBox, energeticCheckBox, enthusiasticCheckBox,
            euphoricCheckBox, exhilaratedCheckBox, fearfulCheckBox, fixed_expressionCheckBox, flatCheckBox,
            frightenedCheckBox, frustratedCheckBox, guardedCheckBox, guiltyCheckBox, happyCheckBox, hopelessCheckBox,
            hostileCheckBox, indignantCheckBox, interestedCheckBox, irritableCheckBox, labileCheckBox,
            lacking_energyCheckBox, matter_of_fact_CheckBox, motivatedCheckBox, nonchalantCheckBox, overwhelmedCheckBox,
            panickyCheckBox, placidCheckBox, powerlessCheckBox, pressuredCheckBox, puzzledCheckBox, relaxedCheckBox,
            remorsefulCheckBox, resentfulCheckBox, sadCheckBox, scowlingCheckBox, self_criticalCheckBox,
            self_deprectaroyCheckBox, self_effacingCheckBox, seriousCheckBox, smilingCheckBox, soberCheckBox,
            spontaneousCheckBox, staringCheckBox, subduedCheckBox, sullenCheckBox, superficialCheckBox,
            suspiciousCheckBox, tearfulCheckBox, tenseCheckBox, unhappyCheckBox)


    for (x in toDoCheckBoxList) {
        centerPanel.add(x)
    }


    //COMBO BOX FUNCTIONALITY


    frame.setSize(950, 600)
    frame.isVisible = true

}
