package aleksandrkim.sampleapplication.feed

import aleksandrkim.sampleapplication.db.entities.Article
import aleksandrkim.sampleapplication.network.models.ProcessedResponse
import aleksandrkim.sampleapplication.repository.Repository
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Single

/**
 * Created by Aleksandr Kim on 21 Jul, 2018 12:50 PM for SampleApplication
 */
class FeedFragmentVM(private val repository: Repository) : ViewModel() {

    var topAllLive: LiveData<List<Article>> = repository.getTopHeadlinesAll()
        private set

    fun fetchNewArticles(): Single<ProcessedResponse> {
        return repository.fetchNewArticles()
    }

    fun removeAllObs(owner: LifecycleOwner) {
        topAllLive.removeObservers(owner)
    }

    companion object {
        const val TAG = "FeedFragmentVM"
    }
}