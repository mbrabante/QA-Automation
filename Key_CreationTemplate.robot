*** Settings ***
Resource    ../Global/GlobalResources.robot

*** Variables ***
${gameURL}    ${EMPTY}

*** Keywords ***
Game Template Scoring is Enabled
    [Arguments]    ${template}
    User Navigate to Sort It
    Search for the game template    ${template}    
    User Edit the Game Template
    Wait Until Element Is Visible    ${loc_headerEdit}    10
    Click Game Options tab
    ${isEnable}    Run Keyword and Return Status    Element Attribute Value Should Be    ${loc_chkScoringSwitch}    ng-reflect-model    true       
    Run Keyword If    '${isEnable}'=='False'    Run Keywords    Click Element    ${loc_btnScoringSwitch}
    ...    AND    Click Element    ${loc_btnUpdateProgress}
    ...    AND    Sleep    1s
    ...    AND    Click REVIEW settings tab        
    ...    AND    Click Element    ${loc_btnUpdateGame}

User send an Invite
    [Arguments]    ${template}    
    User navigate to Sort It
    Search for the game template    ${template}
    User Invite the game template
    Wait Until Element Is Visible    ${loc_inputInviteEmail}    10
    Input Text    ${loc_inputInviteEmail}    ${autoemail}
    Click Invite button
    Sleep    2s
    
Player launch the Sort It Game via ${type}
    Run Keyword If    '${type}'=='Invite'    Get Invite Link And Launch    

Get Invite Link And Launch
    Sleep    1s
    Open Mailbox    host=${emailHost}    user=${emailAddress}    password=${emailPassword}
    ${LATEST}    Wait For Email    sender=${emailSender}    status=UNSEEN    subject=Play the Sort Game    timeout=300    
    ${HTML}    Get Links from Email    ${LATEST}
    Switch Window    MAIN    None    Current
    Set Suite Variable    ${gameURL}    https://${HTML}[2]
    Go To    https://${HTML}[2]
    Mark Email As Read    ${LATEST}
    Close Mailbox              
    
Search for the game template
    [Arguments]    ${template}
    Wait Until Element Is Not Visible    //td[contains(., 'No records to display')]    20   
    Wait Until Element Is Visible    ${loc_inputSearchSortItTemplate}    10
    Input Text    ${loc_inputSearchSortItTemplate}    ${template}
    Click Element    ${loc_btnSearchSortItTemplate}
    
Search the game template
    [Arguments]    ${template}
    Reload Page
    Wait Until Element Is Not Visible    //td[contains(., 'No records to display')]    20   
    Wait Until Element Is Visible    ${loc_inputSearchSortItTemplate}    10
    Input Text    ${loc_inputSearchSortItTemplate}    ${template}
    Click Element    ${loc_btnSearchSortItTemplate}
    
User ${action} the Game Template
    Wait Until Element Is Visible    ${loc_ellipsisActions}    10    
    Click Element    ${loc_ellipsisActions}
    Wait Until Element Is Visible    ${loc_listActions}
    Click Link    ${action}
    
Click ${tab} tab
    Click Element    //a[contains(., '${tab}')]
    
The score will be recorded
    [Arguments]    ${template}
    Go To    ${clientURL}
    User Navigate To Sort It
    Search the game template    ${template}    
    User View All Games the game template
    Wait Until Element Is Visible    ${loc_tblViewAllGames}    10
    Table Column Should Contain    ${loc_tblViewAllGames}    6    ${gameURL}
    Element Should Contain    //td[contains(., '${gameURL}')]/../td[7]    100%
    Element Should Contain    //td[contains(., '${gameURL}')]/../td[8]    Completed   
                  
        