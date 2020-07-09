/**
 * Created on 25 Jun 2019 by happygirlzt
 *
 */

#include <bits/stdc++.h>
using namespace std;

int dist[100005];
bool visited[100005];

vector< pair<int, int> > v[100005];

void dijkstra() {
    multiset< pair<int, int> > q;
    q.insert({0, 1});

    while (!q.empty()) {
        pair< int, int > cur = *q.begin();
        q.erase(q.begin());

        int next = cur.second;
        if (visited[next]) continue;
        visited[next] = true;

        for (int i = 0; i < v[next].size(); i++) {
            int x = v[next][i].first;
            int y = v[next][i].second;

            if (dist[next] + y < dist[x]) {
                dist[x] = dist[next] + y;
                q.insert({dist[x], x});
            }
        }
    }
}

int main() {
    int m, n, x, y, w;
    cin >> n >> m;

    for (int i = 0; i <= n + 4; i++) {
        dist[i] = 1e9;
        visited[i] = false;
    }

    dist[0] = 0;
    dist[1] = 0;

    for (int i = 0; i < m; i++) {
        cin >> x >> y >> w;
        v[x].push_back(make_pair(y, w));
    }

    dijkstra();
    for (int i = 2; i <= n; i++) {
        cout << dist[i] << " ";
    }

    return 0;
}
