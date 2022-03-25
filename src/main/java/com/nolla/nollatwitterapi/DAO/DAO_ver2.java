package com.nolla.nollatwitterapi.DAO;
import com.nolla.nollatwitterapi.Model.Model_ver2;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class DAO_ver2 {

final String INSERT_QUERY = "INSERT INTO tweets_ver2(content_twt) VALUES (:tweet)";
final String SELECT_QUERY = "SELECT * FROM tweets_ver2 ORDER BY created_twt DESC LIMIT 5";
final String DELETE_QUERY = "DELETE FROM tweets_ver2 WHERE twt_id = (:twt_id)";
final String SELECT_LIKE_QUERY = "UPDATE tweets_ver2 SET twt_like = (SELECT twt_like FROM tweets_ver2 WHERE twt_id = (:twt_id)) + 1 WHERE twt_id = (:twt_id)";

private static final String COL_CONT_TWT="content_twt";

public DAO_ver2(NamedParameterJdbcTemplate template) { this.template = template;}

private final NamedParameterJdbcTemplate template;

public String addTweet (String message) throws ExecutionException, InterruptedException {

    Firestore dbFirestore = FirestoreClient.getFirestore();

    ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_CONT_TWT).document(Model_ver2.getContent_twt()).set(message);

    System.out.println("Message received: " + message);
    Map<String, Object> paramMap = new HashMap();
    paramMap.put("tweet", message);
    template.update(INSERT_QUERY, paramMap);
    return collectionsApiFuture.get().getUpdateTime() + "ok";
}

public Model_ver2 getTweets(String content_twt) throws ExecutionException, InterruptedException {

    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection(COL_CONT_TWT).document();
    ApiFuture<DocumentSnapshot> future = documentReference.get();

    DocumentSnapshot document = future.get();

    Model_ver2 model_ver2 = null;

    if(document.exists()) {
        model_ver2 = document.toObject(Model_ver2.class);
        return model_ver2;
    }else {
        return null;
    }
}

    public String deleteTweet(Long twt_id) {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_CONT_TWT).document(twt_id.toString()).delete();
        return "Message with Message ID "+twt_id.toString()+" has been deleted";
}

    public String likeTweet(Long twt_id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_CONT_TWT).document(Model_ver2.getTwt_like().toString()).set(twt_id);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
