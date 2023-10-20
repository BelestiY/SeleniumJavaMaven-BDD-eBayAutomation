//package config;
//
//import net.rcarz.jiraclient.*;
//
//import java.io.File;
//
//public class JiraIssue {
//    private static String projectKey="AI"; //project key=AI corresponds to AGRO INSURANCE
//    private static String issueType="Bug";
//    private static String priority="Medium";
//    private static String jiraURL="https://kifiyaplatforms.atlassian.net";
//    private static String userName="hazezew@kifiya.com";
//    private static String jiraToken="jirataken";
//    private JiraClient jira;
//
//    public JiraIssue(){
//
//    }
//
//    public void create(String summery, String description,String fileName){
//        BasicCredentials cred = new BasicCredentials(userName, jiraToken);
//        jira = new JiraClient(jiraURL, cred);
//        //Crete issue only for owned project
//
//        try {
//            Issue issue = jira.createIssue(projectKey,issueType)
//                    .field(Field.SUMMARY,summery)
//                    .field(Field.DESCRIPTION,description)
//                    .field(Field.ASSIGNEE,userName)
//                    .field(Field.PRIORITY, priority)
//                    .execute();
//
////            Need to add the Assignee value here. Failed to set the Assignee field of Jira issue
////            issue.field(Field.ASSIGNEE, "Name of the assignee");
//
//            System.out.println("Issue Key "+issue.getKey());
//
////            Adding a file attachment to the newly created Jira issue
//            try{
//                File file=new File(fileName);
//                issue.addAttachment(file);
//                issue.update().field(Field.ASSIGNEE,userName);
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        catch (JiraException e){
//            e.printStackTrace();
//        }
//    }
//}