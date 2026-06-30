//shash code

class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }

    @Override
    public int compareTo(Tweet that) {
        return that.time - this.time; // Latest tweet first
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t); // Insert at front
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {

    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {

        timeCounter++;

        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId)) {
            return res;
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = userMap.get(userId);

        // Add self tweets
        int count = 0;
        for (Tweet tweet : user.tweets) {
            pq.offer(tweet);
            count++;
            if (count == 10)
                break;
        }

        // Add followees' tweets
        for (int followeeId : user.followers) {

            User followee = userMap.get(followeeId);

            if (followee == null)
                continue;

            count = 0;

            for (Tweet tweet : followee.tweets) {
                pq.offer(tweet);
                count++;

                if (count == 10)
                    break;
            }
        }

        count = 0;

        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().tweetId);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        userMap.get(followerId).addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId))
            return;

        userMap.get(followerId).removeFollower(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */