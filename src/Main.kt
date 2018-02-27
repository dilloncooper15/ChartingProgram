import java.awt.*
import java.awt.Color.BLACK
import java.awt.Color.CYAN
import java.awt.event.ActionEvent
import java.util.concurrent.Flow
import javax.swing.*
import javax.swing.JComboBox
import javax.swing.border.CompoundBorder


open class MainActivity {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val frame = JFrame("Charting Program")
            val groupListComboBox: JComboBox<String> = JComboBox()
            var selectedItemCache: Any = JComboBox<String>()
            val selectedItemList: MutableList<String> = mutableListOf()
//            val groupListComboBox = DropDownList().dropDownListItemsComboBox()

            frame.isResizable = true
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            val attendanceLabel = JLabel("Attendance:")
            attendanceLabel.isVisible = true


            val centerPanel = JPanel(GridLayout(9, 10))
            frame.add(centerPanel)
            centerPanel.isVisible = true

            val output = TextArea()
            frame.add(output, "South")

            frame.setSize(1000, 600)
            frame.isVisible = true

            fun addCompoundBorder(insideColor: Color, insideThickness: Int, insideCorners: Boolean, outsideColor: Color, outsideThickness: Int, outsideCorners: Boolean): CompoundBorder {
                return BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(insideColor, insideThickness, insideCorners), BorderFactory.createLineBorder(outsideColor, outsideThickness, outsideCorners))
            }


            val didNotAttend = JRadioButton("Did Not Attend")
            val fifteenMinRadioButton = JRadioButton("15 Minutes")
            val thirtyMinRadioButton = JRadioButton("30 Minutes")
            val fortyFiveMinRadioButton = JRadioButton("45 Minutes")
            val sixtyMinRadioButton = JRadioButton("60 Minutes")
            val entireGroupRadioButton = JRadioButton("Entire Group Duration")

            val jRadioButtonList = arrayOf(didNotAttend, fifteenMinRadioButton, thirtyMinRadioButton, fortyFiveMinRadioButton, sixtyMinRadioButton, entireGroupRadioButton)

            val radioButtonGroup = ButtonGroup()

            fun dropDownListItemsComboBox() {
                for (i in DropDownList().dropDownMap.keys) {
                    groupListComboBox.addItem(i)
                }
            }

            groupListComboBox.addActionListener(
                    { _: ActionEvent ->
                        val selectedItem = groupListComboBox.selectedItem
                        val selectedIndex = groupListComboBox.selectedIndex
                        println(selectedItem)
                        println(selectedIndex)
                        if (selectedIndex > 0
                                && selectedItem != selectedItemCache
                                && selectedItem.toString() !in selectedItemList) {
                            output.append(selectedItem.toString() + "\n")
                            selectedItemList.add(selectedItem.toString())
                            selectedItemCache = selectedItem
                        }
                    }
            )

            fun addNorthPanelToFrame(constraintLayoutName: String, flowLayout: FlowLayout, visible: Boolean) {  //constraintDirection : LayoutManager
                val panelAdd = JPanel(flowLayout)
                frame.add(panelAdd, constraintLayoutName)
                panelAdd.isVisible = visible

                panelAdd.add(groupListComboBox)
                panelAdd.border = addCompoundBorder(BLACK, 1, true, CYAN, 4, true)
                groupListComboBox.border = addCompoundBorder(BLACK, 1, true, CYAN, 4, true)
                panelAdd.add(attendanceLabel)
                dropDownListItemsComboBox()
                for (x in jRadioButtonList) {
                    panelAdd.add(x)
                    run { radioButtonGroup.add(x) }
                }
            }


            fun eastPanelAddButton(buttonName: String, visible: Boolean, panelName: JPanel) {
                val jButtonName = JButton(buttonName)
                jButtonName.isVisible = visible
                panelName.add(jButtonName)
            }

            fun addEastPanelToFrame(constraintLayoutName: String, visible: Boolean) {
                val panelAdd = JPanel(FlowLayout(FlowLayout.LEFT))
                panelAdd.layout = BoxLayout(panelAdd, BoxLayout.Y_AXIS)
                frame.add(panelAdd, constraintLayoutName)
                panelAdd.isVisible = visible
                eastPanelAddButton("Reset", true, panelAdd)
                eastPanelAddButton("Enter", true, panelAdd)
            }


            addNorthPanelToFrame("North", FlowLayout(FlowLayout.LEFT), true)
            addEastPanelToFrame("East", true)


/*
----------------- CENTER PANEL ------------
*/
            //Create a new jpanel with flow layout to hold the affect tick boxes.

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


            //COMBO BOX FUNCTIONALITY


        }

    }
}