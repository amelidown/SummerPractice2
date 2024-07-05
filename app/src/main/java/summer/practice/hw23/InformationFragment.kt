package summer.practice.hw23

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import summer.practice.hw23.databinding.FragmentInformationBinding

class InformationFragment : Fragment(R.layout.fragment_information) {
    private var binding: FragmentInformationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)

        val id = arguments?.getInt(getString(R.string.id))
        val list = MuseumRepository.clubs

        var index: Int? = null
        var club: Museum? = null

        for (i in list.indices) {
            if (id?.equals(list[i].id) == true) {
                index = i
            }
        }

        index?.let { club = list[it] }

        binding?.run {
            tvClubName.text = club?.name
            tvCountry.text = getString(R.string.city).plus(club?.city)
            tvLeague.text = getString(R.string.dateoffoundation).plus(club?.dateoffoundation)
            tvInfo.text = getString(R.string.info).plus(club?.info)
            val urlRes = club?.url
            context?.let {
                Glide.with(it)
                    .load(urlRes)
                    .into(tvLogo)
                backButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_informationFragment_to_contactsFragment
                    )
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}