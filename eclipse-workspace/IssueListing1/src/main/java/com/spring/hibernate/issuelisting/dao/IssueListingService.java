package com.spring.hibernate.issuelisting.dao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.spring.hibernate.issuelisting.model.*;
import com.spring.hibernate.issuelisting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.apache.commons.lang3.StringUtils.trim;

@Service
public class IssueListingService {
        @Autowired
        private NodeRepo nodeRepo;
        @Autowired
        private LabelsRepo labelsRepo;
        @Autowired
        private AssigneesRepo assigneesRepo;
        @Autowired
        private IterationRepo iterationRepo;
        @Autowired
        private MileStoneRepo mileStoneRepo;
        @Autowired
        private MasterDataRepo masterDataRepo ;
        @Autowired
        private MasterDataService masterDataService;

        @SuppressWarnings("unchecked")
      @Scheduled(initialDelay = 30000,fixedDelay = 60000)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        public void getIssues() throws IOException, UnirestException, ParseException {
       Boolean hasPreviousPage=true;
       String  startcursor=null;

       while(hasPreviousPage) {
           int fetchFlag = 1;
           nodeRepo.offForeign(); //set foreign constraint  off
           Unirest.setTimeouts(0, 0);
           HttpResponse<String> response = Unirest.post("https://gitlab.com/api/graphql")
                   .header("authority", "gitlab.com")
                   .header("accept", "*/*")
                   .header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8")
                   .header("content-type", "application/json")
                   .header("cookie", "experimentation_subject_id=eyJfcmFpbHMiOnsibWVzc2FnZSI6Iklqa3dNakE0TURBekxUbGpPR1F0TkdVMU5pMWhOakZoTFdRMU5HVmlZamcwTWpsbFpDST0iLCJleHAiOm51bGwsInB1ciI6ImNvb2tpZS5leHBlcmltZW50YXRpb25fc3ViamVjdF9pZCJ9fQ%3D%3D--e8d7cd7fe28691af52d280b8c0fdd52466ccbc54; sidebar_collapsed=false; cf_chl_2=055f7905fe3b836; cf_chl_prog=x11; cf_clearance=I1nSoS9AIJ7xLn3_nZsAGeUqo2A40hfjTPKxcng.Aj8-1654876519-0-150; _sp_ses.6b85=*; OptanonConsent=isGpcEnabled=0&datestamp=Fri+Jun+10+2022+21%3A25%3A20+GMT%2B0530+(India+Standard+Time)&version=6.32.0&isIABGlobal=false&hosts=&consentId=f95d57f1-8dfa-42d7-a36a-2d2e9e82a2b3&interactionCount=1&landingPath=https%3A%2F%2Fgitlab.com%2Fusers%2Fsign_in&groups=C0001%3A1%2CC0003%3A1%2CC0002%3A1%2CC0004%3A1; known_sign_in=TUNHQ3VGQ0FVOHB1MnJSQ241bTFCWUI0YTUzdlh2NmJwbXJUTmFPL2pOSE5BUlFXZnZPNVUyMXRabzVBK1NoMW9YQzg3NkU0YjBtdWN5NmFOTk84MWtEejJHNmZIamd1RG5CRVpBbVBuZ3Y1Q3p3TU5mSjNqTERSOHBnS05BM000QVJ0U2U2MWoxNkhlUTErWjlQNEtRPT0tLU1GcGx1U3JWN1M3alRDVXFIUktiZGc9PQ%3D%3D--6f4b2d2478ddcf95901dbb59feff9b69705a0f50; _gitlab_session=74fd9acde306d520c18dc7bfe585bb5a; _sp_id.6b85=629771f5-e066-493b-bbdc-649d45899988.1652550009.2.1654876533.1652550267.ea186b95-425d-4ab5-9a6c-79d342a11869; experimentation_subject_id=eyJfcmFpbHMiOnsibWVzc2FnZSI6IklqTTFOVE0wTVdFMUxUWXpOakl0TkRBeVlpMDVaalV3TFRVeE1qUmxOV0kyTkRJeE5TST0iLCJleHAiOm51bGwsInB1ciI6ImNvb2tpZS5leHBlcmltZW50YXRpb25fc3ViamVjdF9pZCJ9fQ%3D%3D--ff82a3809e721ffa6dd401d6d1565308539beba9")
                   .header("origin", "https://gitlab.com")
                   .header("referer", "https://gitlab.com/composite_applications/CuraPatient2.0/-/issues/11781")
                   .header("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"102\", \"Google Chrome\";v=\"102\"")
                   .header("sec-ch-ua-mobile", "?0")
                   .header("sec-ch-ua-platform", "\"macOS\"")
                   .header("sec-fetch-dest", "empty")
                   .header("sec-fetch-mode", "cors")
                   .header("sec-fetch-site", "same-origin")
                   .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36")
                   .header("x-csrf-token", "uQlpmmdCmY3nmhG8vdAo9OhHPLQFEh5JdJCOHp0+JzuK2lTZ4bRTxxZg9bYkmRqaqP7rJY1ASLBHLKa2czkHAw==")
                   .header("x-gitlab-feature-category", "team_planning")
                   .body("{\"query\":\"query getIssuesEE($hideUsers: Boolean = false, $isProject: Boolean = false, $isSignedIn: Boolean = false, $fullPath: ID!, $iid: String, $search: String, $sort: IssueSort, $state: IssuableState, $assigneeId: String, $assigneeUsernames: [String!], $authorUsername: String, $confidential: Boolean, $labelName: [String], $milestoneTitle: [String], $milestoneWildcardId: MilestoneWildcardId, $myReactionEmoji: String, $releaseTag: [String!], $releaseTagWildcardId: ReleaseTagWildcardId, $types: [IssueType!], $epicId: String, $iterationId: [ID], $iterationWildcardId: IterationWildcardId, $weight: String, $crmContactId: String, $crmOrganizationId: String, $not: NegatedIssueFilterInput, $beforeCursor: String, $afterCursor: String, $firstPageSize: Int, $lastPageSize: Int) {\\n  project(fullPath: $fullPath) @include(if: $isProject) {\\n    id\\n    issues(\\n      iid: $iid\\n      sort: $sort\\n      search: $search\\n      state: $state\\n      assigneeId: $assigneeId\\n      assigneeUsernames: $assigneeUsernames\\n      authorUsername: $authorUsername\\n      confidential: $confidential\\n      labelName: $labelName\\n      milestoneTitle: $milestoneTitle\\n      milestoneWildcardId: $milestoneWildcardId\\n      myReactionEmoji: $myReactionEmoji\\n      releaseTag: $releaseTag\\n      releaseTagWildcardId: $releaseTagWildcardId\\n      types: $types\\n      epicId: $epicId\\n      iterationId: $iterationId\\n      iterationWildcardId: $iterationWildcardId\\n      weight: $weight\\n      crmContactId: $crmContactId\\n      crmOrganizationId: $crmOrganizationId\\n      not: $not\\n      before: $beforeCursor\\n      after: $afterCursor\\n      first: $firstPageSize\\n      last: $lastPageSize,\\n      \\n\\n    ) {\\n      pageInfo {\\n        ...PageInfo\\n      }\\n      nodes {\\n        ...IssueFragment\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n}\\n\\nfragment PageInfo on PageInfo {\\n  hasNextPage\\n  hasPreviousPage\\n  startCursor\\n  endCursor\\n  __typename\\n}\\n\\nfragment IssueFragment on Issue {\\n  iid\\n  createdAt\\n  humanTimeEstimate\\n  mergeRequestsCount\\n  title\\n  state\\n  updatedAt\\n  userDiscussionsCount @include(if: $isSignedIn)\\n  webUrl\\n  assignees @skip(if: $hideUsers) {\\n    nodes {\\n      ...UserFragment\\n    }\\n  }\\n  author @skip(if: $hideUsers) {\\n    ...UserFragment\\n  }\\n  labels {\\n    nodes {\\n    ...LabelFragment\\n    }\\n  }\\n  milestone {\\n    ...MilestoneFragment\\n  }\\n  iteration {\\n    ...IterationFragment\\n  }\\n}\\n\\nfragment UserFragment on User {\\n    id\\n    name\\n    webUrl\\n}\\n\\nfragment LabelFragment on Label {\\n    id\\n    title\\n}\\n\\nfragment MilestoneFragment on Milestone {\\n    id\\n    title\\n}\\n\\nfragment IterationFragment on Iteration {\\n  id\\n  title\\n  startDate\\n  dueDate\\n  iterationCadence {\\n    title\\n  }\\n}\\n\",\"variables\":{\"hideUsers\":false,\"isProject\":true,\"isSignedIn\":true,\"fullPath\":\"composite_applications/CuraPatient2.0\",\"sort\":\"updated_desc\",\"state\":\"all\",\"beforeCursor\":" + startcursor + ",\"lastPageSize\":1000,\"afterCursor\":null,\"types\":[\"ISSUE\",\"INCIDENT\",\"TEST_CASE\"]}}")
                   .asString();
           ObjectMapper mapper = new ObjectMapper();
           Map<String, Object> map = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
           });
          System.out.println(map);
           LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) map.get("data");
           LinkedHashMap<String, Object> project = (LinkedHashMap<String, Object>) data.get("project");
           LinkedHashMap<String, Object> issues = (LinkedHashMap<String, Object>) project.get("issues");
           ArrayList<Map<String, Object>> arrNodes = (ArrayList<Map<String, Object>>) issues.get("nodes");
           LinkedHashMap<String, Object> pageinfo = (LinkedHashMap<String, Object>) issues.get("pageInfo");
           String cursor = pageinfo.get("startCursor").toString();
           startcursor = "\"" + cursor + "\"";
           hasPreviousPage = (Boolean) pageinfo.get("hasPreviousPage");
           Date date = nodeRepo.maxDate();   //get max updated date from database
           for (int i = 0; i < arrNodes.size(); i++) {
               DateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
               java.util.Date update = simpleDateFormatDate.parse(arrNodes.get(i).get("updatedAt").toString());
               if(date != null) {
                   if (date.compareTo(update) == 0) {
                      nodeRepo.deletenodes(arrNodes.get(i).get("iid").toString());
                   }
                   if(date.compareTo(update) >0 && fetchFlag==1){
                    fetchFlag=0;
                       continue;
                   }
              }
                   Nodes nodes = new Nodes();
                   nodes.setIid(Integer.parseInt(arrNodes.get(i).get("iid").toString()));
                   DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   java.util.Date createdDate = simpleDateFormat.parse(arrNodes.get(i).get("createdAt").toString());
                   nodes.setNodecreatedAt(createdDate);
                   if(arrNodes.get(i).get("humanTimeEstimate") != null ) {
                       nodes.setHumanTimeEstimate(arrNodes.get(i).get("humanTimeEstimate").toString());
                   }else{
                       nodes.setHumanTimeEstimate("null");
                   }
                   nodes.setMergeRequestsCount((int) arrNodes.get(i).get("mergeRequestsCount"));
                   nodes.setNodetitle(trim(arrNodes.get(i).get("title").toString()));
                   DateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                   java.util.Date updatedDate = simpleDateFormat1.parse(arrNodes.get(i).get("updatedAt").toString());
                   nodes.setNodeupdatedAt(updatedDate);
                   nodes.setUserDiscussionsCount((int) arrNodes.get(i).get("userDiscussionsCount"));
                   nodes.setNodeWebUrl(trim(arrNodes.get(i).get("webUrl").toString()));
                   LinkedHashMap<String, Object> author = (LinkedHashMap<String, Object>) arrNodes.get(i).get("author");
                   nodes.setAuthId(trim(author.get("id").toString()));
                   nodes.setAuthname(trim(author.get("name").toString()));
                   nodes.setAuthwebUrl(trim(author.get("webUrl").toString()));
                   nodes.setState(trim(arrNodes.get(i).get("state").toString()));
                   nodeRepo.save(nodes);
                   LinkedHashMap<String, Object> labelsList = (LinkedHashMap<String, Object>) arrNodes.get(i).get("labels");
                   ArrayList<Map<String, Object>> arrnodes = new ArrayList<>();
                   arrnodes.addAll((Collection<? extends Map<String, Object>>) labelsList.get("nodes"));
                 labelsRepo.deleteLabels(nodes.getIid());
               String module=null;
               String labelproject=null;
               String team=null;
               String type= null;
               String state= null;
               Date dur = null;
               Date start= null;
               String miletitle=null;
                   for (int l = 0; l < arrnodes.size(); l++) {
                       Labels labels = new Labels();
                       String title =  trim((String) arrnodes.get(l).get("title"));
                       String[] titlearr = title.split("\\::");
                       for (int m = 0; m <= titlearr.length - 1; m++) {
                           if (m % 2 == 0) {
                               labels.setTitleKey(trim(titlearr[m]));
                               //module
                               if(labels.getTitleKey().equals("Module")){
                                   module=trim(titlearr[m+1]);
                               }
                               //customer
                               if(labels.getTitleKey().equals("Project")){
                                   labelproject=trim(titlearr[m+1]);
                               }
                               //Team
                               if(labels.getTitleKey().equals("Team")){
                                   team=trim(titlearr[m+1]);
                               }
                               //Type
                               if(labels.getTitleKey().equals("Type")){
                                   type=trim(titlearr[m+1]);
                               }
                               //State
                               if(labels.getTitleKey().equals("state")){
                                   state=trim(titlearr[m+1]);
                               }
                               } else {
                               labels.setTitleValue(trim(titlearr[m]));
                              }
                       }
                       labels.setNodeLabel(nodes);
                       labels.setLableid(trim(arrnodes.get(l).get("id").toString()) + "/" + nodes.getIid() + "/" + l);
                       labelsRepo.save(labels);
                   }
                   LinkedHashMap<String, Object> assigneesList = (LinkedHashMap<String, Object>) arrNodes.get(i)
                           .get("assignees");
                   ArrayList<Map<String, Object>> arrassignees = new ArrayList<>();
                   arrassignees.addAll((Collection<? extends Map<String, Object>>) assigneesList.get("nodes"));
                   assigneesRepo.deleteAssignees(nodes.getIid());

                   for (int l = 0; l < arrassignees.size(); l++) {
                       Assignees assignees = new Assignees();
                       assignees.setAssigneeid(trim(arrassignees.get(l).get("id").toString()) + "/" + nodes.getIid() + "/" + l);
                       assignees.setAssigneename(trim(arrassignees.get(l).get("name").toString()));
                       assignees.setAssigneeweburl(trim(arrassignees.get(l).get("webUrl").toString()));
                       assignees.setNodeAssignees(nodes);
                       assigneesRepo.save(assignees);
                   }

                   if (arrNodes.get(i).get("iteration") != null) {
                       LinkedHashMap<String, Object> iterationList = (LinkedHashMap<String, Object>) arrNodes.get(i)
                               .get("iteration");
                       iterationRepo.deleteIteration(nodes.getIid());

                           Iteration iteration = new Iteration();
                           iteration.setIterationid(trim(iterationList.get("id").toString()) + "/" + nodes.getIid());
                           if (iterationList.get("title") != null) {
                               iteration.setIterationtitle(trim(iterationList.get("title").toString()));
                           } else {
                               iteration.setIterationtitle("null");
                           }
                           DateFormat simpleDateFormatDate1 = new SimpleDateFormat("yyyy-MM-dd");
                           java.util.Date IterationdueDate = simpleDateFormatDate1.parse(trim(iterationList.get("dueDate").toString()));
                           iteration.setIterationdueDate(IterationdueDate);
                           dur= iteration.getIterationdueDate();
                           DateFormat simpleDateFormatDate2 = new SimpleDateFormat("yyyy-MM-dd");
                           java.util.Date IterationstartDate = simpleDateFormatDate2.parse(trim(iterationList.get("startDate").toString()));
                           iteration.setIterationstartDate(IterationstartDate);
                           start= (Date) iteration.getIterationstartDate();
                           if (iterationList.get("iterationCadence") != null) {
                               LinkedHashMap<String, Object> iterationCadenceList = (LinkedHashMap<String, Object>)
                                       iterationList.get("iterationCadence");
                               iteration.setIterationCadenceTitle(iterationCadenceList.get("title").toString());
                           }else{
                               iteration.setIterationCadenceTitle("null");
                           }
                           iteration.setNodeIteration(nodes);
                          iterationRepo.save(iteration);
                       }

                   if (arrNodes.get(i).get("milestone") != null) {
                       LinkedHashMap<String, Object> milestoneList = (LinkedHashMap<String, Object>) arrNodes.get(i)
                               .get("milestone");
                       mileStoneRepo.deleteMileStone(nodes.getIid());
                       for (int j = 0; j < milestoneList.size()-1; j++) {
                           MileStone mileStone = new MileStone();
                           mileStone.setMilestoneid(trim(milestoneList.get("id").toString()) + "/" + nodes.getIid() + "/" + j);
                           if(milestoneList.get("title")!=null){
                             mileStone.setMilestonetitle(trim(milestoneList.get("title").toString()));
                             miletitle=mileStone.getMilestonetitle();
                         }else{
                             mileStone.setMilestonetitle("null");
                         }
                           mileStone.setNodeMileStone(nodes);
                           mileStoneRepo.save(mileStone);
                       }
                   }
            nodeRepo.update(module,miletitle,labelproject,dur,start,team,type,state,nodes.getIid());
               }
       }
            masterDataService.addEmployee();
            System.out.println("Run----");
            nodeRepo.onForeign();
        }
    }