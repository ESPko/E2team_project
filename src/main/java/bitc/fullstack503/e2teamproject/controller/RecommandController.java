package bitc.fullstack503.e2teamproject.controller;


import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class RecommandController {
  @Autowired
  PlaceService placeService;

  //  오징어게임
  @RequestMapping("/rec1")
  public ModelAndView recommand1() {
    return new ModelAndView("/place/recommandPage1");
  }

  //  혼자놀기
  @RequestMapping("/rec2")
  public ModelAndView recommand2() {
    ModelAndView mav = new ModelAndView("/place/recommandPage2");
    PlaceEntity library = placeService.findPlaceLibrary();
    PlaceEntity studio = placeService.findPlaceSelfStudio();
    PlaceEntity baking = placeService.findPlaceBaking();
    PlaceEntity balling = placeService.findPlaceBalling();
    PlaceEntity surfing = placeService.findPlaceSurfing();
    PlaceEntity skyDiving = placeService.findPlaceSkyDiving();
    PlaceEntity shooting = placeService.findPlaceShooting();
    PlaceEntity convention = placeService.findPlaceConvention();
    PlaceEntity coinSing = placeService.findPlaceCoinSing();
    PlaceEntity climbing = placeService.findPlaceClimbing();
    PlaceEntity tikTok = placeService.findPlaceTikTok();
    PlaceEntity parasail = placeService.findPlaceParasail();
    mav.addObject("libraryList", library);
    mav.addObject("studioList", studio);
    mav.addObject("bakingList", baking);
    mav.addObject("ballingList", balling);
    mav.addObject("surfingList", surfing);
    mav.addObject("skyDivingList", skyDiving);
    mav.addObject("shootingList", shooting);
    mav.addObject("conventionList", convention);
    mav.addObject("coinSingList", coinSing);
    mav.addObject("climbingList", climbing);
    mav.addObject("tikTokList", tikTok);
    mav.addObject("parasailList", parasail);
    return mav;
  }

  //  가족
  @RequestMapping("/rec3")
  public ModelAndView recommand3() {
    ModelAndView mav = new ModelAndView("/place/recommandPage3");
    PlaceEntity kidsCafe = placeService.findPlaceKidsCafe();
    PlaceEntity baking = placeService.findPlaceBaking();
    PlaceEntity slime = placeService.findPlaceSlime();
    PlaceEntity kidzania = placeService.findPlaceKizania();
    PlaceEntity animal = placeService.findPlaceAnimal();
    PlaceEntity gongBang = placeService.findPlaceGold();
    PlaceEntity convention = placeService.findPlaceConvention();
    PlaceEntity themePark = placeService.findPlaceThemePark();
    mav.addObject("kidsCafeList", kidsCafe);
    mav.addObject("bakingList", baking);
    mav.addObject("slimeList", slime);
    mav.addObject("kidzaniaList", kidzania);
    mav.addObject("animalList", animal);
    mav.addObject("gongBangList", gongBang);
    mav.addObject("conventionList", convention);
    mav.addObject("themeParkList" , themePark);
    return mav;
  }

  //  exciting
  @RequestMapping("/rec4")
  public ModelAndView recommand4() {
    ModelAndView mav = new ModelAndView("/place/recommandPage4");
    PlaceEntity climbing = placeService.findPlaceClimbing();
    PlaceEntity cart = placeService.findPlaceCart();
    PlaceEntity zipLine = placeService.findPlaceZipLine();
    PlaceEntity shooting = placeService.findPlaceShooting();
    PlaceEntity surfing = placeService.findPlaceSurfing();
    PlaceEntity skyDiving = placeService.findPlaceSkyDiving();
    PlaceEntity survival = placeService.findPlaceSurvival();
    PlaceEntity escape = placeService.findPlaceEscapeRoom();
    PlaceEntity loogi = placeService.findPlaceLoogi();
    PlaceEntity themePark = placeService.findPlaceThemePark();
    PlaceEntity partyRoom = placeService.findPlacePartyRoom();
    PlaceEntity parasail = placeService.findPlaceParasail();
    mav.addObject("climbingList", climbing);
    mav.addObject("cartList", cart);
    mav.addObject("zipLineList", zipLine);
    mav.addObject("shootingList", shooting);
    mav.addObject("surfingList", surfing);
    mav.addObject("skyDivingList", skyDiving);
    mav.addObject("survivalList", survival);
    mav.addObject("escapeList", escape);
    mav.addObject("loogiList", loogi);
    mav.addObject("themeParkList", themePark);
    mav.addObject("partyRoomList", partyRoom);
    mav.addObject("parasailList", parasail);
    return mav;
  }

  //  Couple
  @RequestMapping("/rec5")
  public ModelAndView recommand5() {
    ModelAndView mav = new ModelAndView("/place/recommandPage5");
    PlaceEntity gonBang = placeService.findPlaceGold();
    PlaceEntity baking = placeService.findPlaceBaking();
    PlaceEntity loogi = placeService.findPlaceLoogi();
    PlaceEntity studio = placeService.findPlaceSelfStudio();
    PlaceEntity zipLine = placeService.findPlaceZipLine();
    PlaceEntity themePark = placeService.findPlaceThemePark();
    PlaceEntity coinSing = placeService.findPlaceCoinSing();
    PlaceEntity animal = placeService.findPlaceAnimal();
    mav.addObject("gonBangList", gonBang);
    mav.addObject("bakingList", baking);
    mav.addObject("loogiList", loogi);
    mav.addObject("studioList", studio);
    mav.addObject("zipLineList", zipLine);
    mav.addObject("themeParkList", themePark);
    mav.addObject("coinSingList", coinSing);
    mav.addObject("animalList", animal);
    return mav;
  }

  //  friend
  @RequestMapping("/rec6")
  public ModelAndView recommand6() {
    ModelAndView mav = new ModelAndView("/place/recommandPage6");
    PlaceEntity animal = placeService.findPlaceAnimal();
    PlaceEntity board = placeService.findPlaceBoard();
    PlaceEntity balling = placeService.findPlaceBalling();
    PlaceEntity cart = placeService.findPlaceCart();
    PlaceEntity coinSing = placeService.findPlaceCoinSing();
    PlaceEntity loogi = placeService.findPlaceLoogi();
    PlaceEntity escape = placeService.findPlaceEscapeRoom();
    PlaceEntity maid = placeService.findPlaceMaid();
    mav.addObject("animalList", animal);
    mav.addObject("boardList", board);
    mav.addObject("ballingList", balling);
    mav.addObject("cartList", cart);
    mav.addObject("coinSingList", coinSing);
    mav.addObject("loogiList", loogi);
    mav.addObject("escapeList", escape);
    mav.addObject("maidList", maid);
    return mav;
  }
}
