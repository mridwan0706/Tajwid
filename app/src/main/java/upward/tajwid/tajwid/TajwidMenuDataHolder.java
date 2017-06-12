package upward.tajwid.tajwid;

import java.util.HashMap;

import upward.tajwid.main.R;

public class TajwidMenuDataHolder {

	public final static String[] mainMenu = {"Hukum nun sukun/tanwin", "Hukum mim sukun", "Hukum mim tasydid dan nun tasydid", "Macam-macam idghom",
											"Hukum lam ta'rif", "Hukum lam dan ro'", "Qolqolah", "Hukum bacaan mad", "Waqof", "Bacaan Khusus"};
	private static HashMap<String, TajwidSubMenu[]> menus;
	
	public static TajwidSubMenu[] getSubMenu(String menu){
		if(menus == null){
			menus = new HashMap<String, TajwidSubMenu[]>();
			
			// Nun sukun
			TajwidSubMenu idhar = new TajwidSubMenu("Idhar Halqi", R.layout.idhar);
			idhar.setExampleSounds(new int[]{R.raw.contoh_izhar});
			
			TajwidSubMenu idgham = new TajwidSubMenu("Idgham", R.layout.idgham);
			idgham.setExampleSounds(new int[]{R.raw.contoh_idgham_bi_la_ghunnah, R.raw.contoh_idgham_bighunnah, R.raw.contoh_idgham_satukata});
			
			TajwidSubMenu ikhfaa = new TajwidSubMenu("Ikhfaa'", R.layout.ikhfa);
			ikhfaa.setExampleSounds(new int[]{R.raw.contoh_ikhfa});
			
			TajwidSubMenu iqlab = new TajwidSubMenu("Iqlab", R.layout.iqlab);
			iqlab.setExampleSounds(new int[]{R.raw.contoh_iqlab});
			
			TajwidSubMenu[] subMenu1 = {idhar, idgham, ikhfaa, iqlab};
			menus.put(mainMenu[0], subMenu1);
			
			
			
			// Mim sukun
			TajwidSubMenu idharSyafawi = new TajwidSubMenu("Idhar Syafawi", R.layout.idhar_syafawi);
			idharSyafawi.setExampleSounds(new int[]{R.raw.contoh_izhar_syafawi});
			
			TajwidSubMenu ikhfaSyafawi = new TajwidSubMenu("Ikhfaa' Syafawi", R.layout.ikhfa_syafawi);
			ikhfaSyafawi.setExampleSounds(new int[]{R.raw.contoh_ikhfa_syafawi});
			
			TajwidSubMenu idghamMimi = new TajwidSubMenu("Idgham Mimi", R.layout.idghom_mislain);
			idghamMimi.setExampleSounds(new int[]{R.raw.contoh_idgham_mislain});
			
			TajwidSubMenu[] subMenu2 = {idharSyafawi, ikhfaSyafawi, idghamMimi};
			menus.put(mainMenu[1], subMenu2);
			
			
			
			// Mim tasydid dan nun tasydid
			TajwidSubMenu nunMimTasydid = new TajwidSubMenu("", R.layout.nun_mim_tasydid);
			nunMimTasydid.setExampleSounds(new int[]{R.raw.nun_mim_tasydid});
			
			TajwidSubMenu[] subMenu3 = {nunMimTasydid};
			menus.put(mainMenu[2], subMenu3);
			
			
			
			
			// Macam-macam idghom
			TajwidSubMenu idghamMutamatsilain = new TajwidSubMenu("Idghom Mutamatsilain", R.layout.idgham_mutamatsilain);
			idghamMutamatsilain.setExampleSounds(new int[]{R.raw.contoh_idgham_mutamatsilain});
			
			TajwidSubMenu idghamMutajanisain = new TajwidSubMenu("Idghom Mutajanisain", R.layout.idgham_mutajanisain);
			idghamMutajanisain.setExampleSounds(new int[]{R.raw.contoh_idgham_mutajanisain});
			
			TajwidSubMenu idghamMutaqoribain = new TajwidSubMenu("Idghom Mutaqoribain", R.layout.idgham_mutaqaribain);
			idghamMutaqoribain.setExampleSounds(new int[]{R.raw.contoh_idgham_mutaqaribain});
			
			TajwidSubMenu[] subMenu4 = {idghamMutamatsilain, idghamMutajanisain, idghamMutaqoribain};
			menus.put(mainMenu[3], subMenu4);
			
			
			
			
			// Lam ta'rif
			TajwidSubMenu idharQamariyah = new TajwidSubMenu("Idhar Qomariyah", R.layout.idhar_qamariah);
			
			TajwidSubMenu idghamSyamsiyah = new TajwidSubMenu("Idghom Syamsiyah", R.layout.idgham_syamsiyah);
			
			TajwidSubMenu[] subMenu5 = {idharQamariyah, idghamSyamsiyah};
			menus.put(mainMenu[4], subMenu5);
			
			
			
			
			// Lam dan ro
			TajwidSubMenu lamTipisDanTebal = new TajwidSubMenu("Lam Al-jalalah", R.layout.lafadz_aljalalah);
			lamTipisDanTebal.setExampleSounds(new int[]{R.raw.contoh_lam_aljalalah_badafathah, R.raw.contoh_lam_aljalalah_badakasrah});
			
			TajwidSubMenu roTipisDanTebal = new TajwidSubMenu("Ro' Tafkhim dan Tarqiq", R.layout.ra_tafkhim_tarqiq);
			
			TajwidSubMenu roTipisAtauTebal = new TajwidSubMenu("Ro' Jawajul Wahjhain", R.layout.ra_jawalul_wahjain);
			
			TajwidSubMenu[] subMenu6 = {lamTipisDanTebal, roTipisDanTebal, roTipisAtauTebal};
			menus.put(mainMenu[5], subMenu6);
			
			
			
			
			// Qalqalah
			TajwidSubMenu qalqalah = new TajwidSubMenu("", R.layout.qalqalah);
			qalqalah.setExampleSounds(new int[]{R.raw.contoh_qalqalah_sughro, R.raw.contoh_qalqalah_kubro});
			
			TajwidSubMenu[] subMenu7 = {qalqalah};
			menus.put(mainMenu[6], subMenu7);
			
			
			
			
			// Mad
			TajwidSubMenu madThobii = new TajwidSubMenu("Mad Thobi'i", R.layout.mad_thobii);
			madThobii.setExampleSounds(new int[]{R.raw.mad_thobii});
			
			TajwidSubMenu madWajibMuttashil = new TajwidSubMenu("Mad Wajib Muttashil", R.layout.mad_wajib_muttashil);
			madWajibMuttashil.setExampleSounds(new int[]{R.raw.mad_wajib_muttashil});
			
			TajwidSubMenu madJaizMunfashil = new TajwidSubMenu("Mad Jaiz Munfashil", R.layout.mad_jaiz_munfashil);
			madJaizMunfashil.setExampleSounds(new int[]{R.raw.mad_jaiz_munfashil});
			
			TajwidSubMenu madLazimMuttasaqqolKilmi = new TajwidSubMenu("Mad Lazim Muttasaqqol Kilmi", R.layout.mad_lazim_muttasaqqol_kilmi);
			madLazimMuttasaqqolKilmi.setExampleSounds(new int[]{R.raw.mad_lazim_muttasaqqal_kilmi});
			
			TajwidSubMenu madLazimMukhoffafKilmi = new TajwidSubMenu("Mad Lazim Mukhoffaf Kilmi", R.layout.mad_lazim_mukhoffaf_kilmi);
			madLazimMukhoffafKilmi.setExampleSounds(new int[]{R.raw.mad_lazim_mukhaffaf_kilmi_1, R.raw.mad_lazim_mukhaffaf_kilmi_2});
			
			TajwidSubMenu madLin = new TajwidSubMenu("Mad Layyin", R.layout.mad_lin);
			madLin.setExampleSounds(new int[]{R.raw.mad_lin});
			
			TajwidSubMenu madAridlLissukun = new TajwidSubMenu("Mad Aridl Lissukun", R.layout.mad_aridl_lissukun);
			madAridlLissukun.setExampleSounds(new int[]{R.raw.mad_arid_lissukun});
			
			TajwidSubMenu madShilahQoshiroh = new TajwidSubMenu("Mad Shilah Qoshiroh", R.layout.mad_shilah_qoshiroh);
			madShilahQoshiroh.setExampleSounds(new int[]{R.raw.mad_silah_qasirah});
			
			TajwidSubMenu madShilahThowilah = new TajwidSubMenu("Mad Shilah Thowilah", R.layout.mad_shilah_thowilah);
			madShilahThowilah.setExampleSounds(new int[]{R.raw.mad_silah_tawilah});
			
			TajwidSubMenu madIwadl = new TajwidSubMenu("Mad 'Iwadl", R.layout.mad_iwadl);
			madIwadl.setExampleSounds(new int[]{R.raw.mad_iwadl});
			
			TajwidSubMenu madBadal = new TajwidSubMenu("Mad Badal", R.layout.mad_badal);
			madBadal.setExampleSounds(new int[]{R.raw.mad_badal});
			
			TajwidSubMenu madLazimHarfiMukhoffaf = new TajwidSubMenu("Mad Lazim Harfi Mukhoffaf", R.layout.mad_lazim_harfi_mukhoffaf);
			madLazimHarfiMukhoffaf.setExampleSounds(new int[]{R.raw.mad_lazim_harfi_mukhoffaf});
			
			TajwidSubMenu madLazimHarfiMutsaqqol = new TajwidSubMenu("Mad Lazim Harfi Mutsaqqol", R.layout.mad_tamkin);
			madLazimHarfiMutsaqqol.setExampleSounds(new int[]{R.raw.mad_lazim_harfi_mutsaqqol});
			
			TajwidSubMenu madTamkin = new TajwidSubMenu("Mad Tamkin", R.layout.mad_tamkin);
			
			TajwidSubMenu madFarq = new TajwidSubMenu("Mad Farq", R.layout.mad_farq);
			madFarq.setExampleSounds(new int[]{R.raw.mad_farq});
			
			TajwidSubMenu[] subMenu8 = {madThobii, madWajibMuttashil, madJaizMunfashil,
					madLazimMuttasaqqolKilmi, madLazimMukhoffafKilmi, madLin,
					madAridlLissukun, madShilahQoshiroh, madShilahThowilah,
					madIwadl, madBadal, madLazimHarfiMukhoffaf,
					madLazimHarfiMutsaqqol, madTamkin, madFarq};
			menus.put(mainMenu[7], subMenu8);
			
			
			
			
			// Tanda waqaf
			TajwidSubMenu[] subMenu9 = {new TajwidSubMenu("", R.layout.tanda_waqaf)};
			menus.put(mainMenu[8], subMenu9);
			
			
			
			
			// Bacaan khusus
			TajwidSubMenu hamzahWasl = new TajwidSubMenu("Hamzah Wasl", R.layout.hamzah_washal);
			
			TajwidSubMenu nunIwadl = new TajwidSubMenu("Nun Iwadl", R.layout.nun_iwadl);
			nunIwadl.setExampleSounds(new int[]{R.raw.nun_iwadl});
			
			TajwidSubMenu isymam = new TajwidSubMenu("Isymam", R.layout.isymam);
			//isymam.setExampleSounds(new int[]{R.raw.mad_jaiz_munfashil});
			
			TajwidSubMenu imalah = new TajwidSubMenu("Imalah", R.layout.imalah);
			imalah.setExampleSounds(new int[]{R.raw.imalah});
			
			TajwidSubMenu[] subMenu10 = {hamzahWasl, nunIwadl, isymam, imalah};
			menus.put(mainMenu[9], subMenu10);
		}
		
		return menus.get(menu);
	}
}
